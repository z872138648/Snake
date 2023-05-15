<template>
    <div class="container">
        <div class="row">
            <div class="col-3">
                <div class="card" style="margin-top: 20px;">
                    <div class="card-body">
                        <img :src="$store.state.user.photo" alt="" style="width: 100%;">
                    </div>
                </div>
            </div>
            <div class="col-9">
                <div class="card" style="margin-top: 20px;">
                    <div class="card-header">
                        <span style="font-size: 130%">我的工单</span>
                        <button type="button" class="btn btn-primary float-end" data-bs-toggle="modal"
                            data-bs-target="#add-feedback-btn">
                            创建反馈
                        </button>

                        <!-- 新建反馈 -->
                        <div class="modal fade" id="add-feedback-btn" tabindex="-1">
                            <div class="modal-dialog modal-xl">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">创建反馈</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="mb-3">
                                            <label for="add-feedback-title" class="form-label">标题</label>
                                            <input v-model="feedbackadd.title" type="text" class="form-control"
                                                id="add-feedback-title" placeholder="请输入反馈的标题">
                                        </div>
                                        <div class="mb-3">
                                            <label for="add-feedback-title" class="form-label" >投诉类型</label>
                                            <select class="form-control" v-model="feedbackadd.type" placeholder="请选择反馈的类型">
                                                <option>举报类</option>
                                                <option>BUG提交类</option>
                                                <option>建议类</option>
                                            </select>

                                        </div>
                                        <div class="mb-3">
                                            <label for="add-feedback-description" class="form-label">简介</label>
                                            <textarea v-model="feedbackadd.feedback_content" class="form-control"
                                                id="add-feedback-description" rows="3"
                                                placeholder="请输入反馈内容"></textarea>
                                        </div>
            
                                    </div>
                                    <div class="modal-footer">
                                        <div class="error-message">{{ feedbackadd.error_message }}</div>
                                        <button type="button" class="btn btn-primary" @click="add_feedback">创建</button>
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>标题</th>
                                    <th>创建时间</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr v-for="feedback in feedbacks" :key="feedback.id">
                                    <td>{{ feedback.title }}</td>
                                    <td>{{ feedback.createtime }}</td>
                                    <td>{{ feedback.status }}</td>
                                    <td>
                                        <button type="button" class="btn btn-secondary" style="margin-right: 10px;"
                                            data-bs-toggle="modal"
                                            :data-bs-target="'#update-feedback-modal-' + feedback.id">查看</button>
                                        <button type="button" class="btn btn-danger"
                                            @click="remove_feedback(feedback)">删除</button>
                                        <!--修改-->
                                        <div class="modal fade" :id="'update-feedback-modal-' + feedback.id" tabindex="-1">
                                            <div class="modal-dialog modal-xl">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title">查看工单</h5>
                                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                            aria-label="Close"></button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="mb-3">
                                                            <label for="update-feedback-title" class="form-label">标题</label>
                                                            <input v-model="feedback.title" type="text" class="form-control"
                                                                id="update-title" readonly>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="update-feedback-type" class="form-label">类型</label>
                                                            <input v-model="feedback.type" type="text"
                                                                class="form-control" id="update-title" readonly>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="update-feedback-status" class="form-label">状态</label>
                                                            <input v-model="feedback.status" type="text"
                                                                class="form-control" id="update-title" readonly>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="update-feedback-feedbackContent"
                                                                class="form-label">详细内容</label>
                                                            <textarea v-model="feedback.feedbackContent"
                                                                class="form-control" id="update-feedback-description"
                                                                rows="3" readonly></textarea>
                                                        </div>

                                                    </div>
                                                    <div class="modal-footer">
                                                        <div class="error-message">{{ feedback.error_message }}</div>
                                                        <!-- <button type="button" class="btn btn-primary"
                                                            @click="update_feedback(feedback)">保存修改</button> -->
                                                        <button type="button" class="btn btn-secondary"
                                                            data-bs-dismiss="modal">关闭</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- <div class="row">
        <div class="col-3">
            <div class="card" style="margin-top: 20px;">
                <div class="card-body">
                    <img :src="$store.state.user.photo" alt="" style="width: 100%;">
                </div>
            </div>
        </div>
        <div class="col-9">
            <div class="card" style="margin-top: 20px">
                <ul class="nav nav-tabs " id="pills-tab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="pills-home-tab" data-toggle="pill" data-target="#pills-home"
                            type="button" role="tab" aria-controls="pills-home" aria-selected="true">我的反馈</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="pills-profile-tab" data-toggle="pill" data-target="#pills-profile"
                            type="button" role="tab" aria-controls="pills-profile" aria-selected="false">提交反馈</button>
                    </li>
                </ul>
            </div>
            <div class="tab-content card" id="pills-tabContent">
                <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab"
                    style="margin-top: 20px">
                    <table class="table table-hover text-center">
                        <tr>
                            <th>标题</th>
                            <th>时间</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        <tr>

                        </tr>
                    </table>
                </div>
                <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">提交反馈</div>
            </div>
        </div>
    </div> -->
</template>

<script>

import { reactive, ref } from 'vue'
import $ from 'jquery'
import { Modal } from 'bootstrap/dist/js/bootstrap'
import { useStore } from 'vuex'
export default {
    setup() {
        const store = useStore();
        let feedbacks = ref([]);
        const feedbackadd = reactive({
            title: "",
            status: "",
            feedback_content: "",
            error_message: "",
        })
        
        const refresh_feedbacks = () => {
            $.ajax({
                url: "http://127.0.0.1:3000/user/feedback/getlist/",
                type: "get",
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    feedbacks.value = resp;
                    console.log(feedbacks);
                }
            })
        }
        refresh_feedbacks();
        const add_feedback = () => {
            feedbackadd.error_message = "";
            $.ajax({
                url: "http://127.0.0.1:3000/user/feedback/add/",
                type: "post",
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                data: {
                    title: feedbackadd.title,
                    feedback_content: feedbackadd.feedback_content,
                    type: feedbackadd.type
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        feedbackadd.title = "";
                        feedbackadd.feedback_content = "";
                        feedbackadd.status = "";
                        Modal.getInstance("#add-feedback-btn").hide();
                        refresh_feedbacks();
                    } else {
                        feedbackadd.error_message = resp.error_message;
                    }
                }

            })
        }
        const remove_feedback = (feedback) => {
            $.ajax({
                url: "http://127.0.0.1:3000/user/feedback/remove/",
                type: "post",
                data: {
                    feedback_id: feedback.id,
                },
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        refresh_feedbacks();
                    }
                }
            })
        }
        return {
            feedbacks,
            feedbackadd,
            add_feedback,
            remove_feedback
        }
    }
}
</script>

<style scoped>
</style>
