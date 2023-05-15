<template>
    <ContentField>
        <div class="row">
            <div class="col-lg-12 text-center" style="margin-top:40px;margin-bottom:40px;">
                <h2>用户讨论</h2>
            </div>

            
        </div>
        <div class="row">
            <div class="col-lg-4"></div>
            <div class="col-lg-4">
                <input placeholder="请输入文章名称" class="form-control" />
            </div>
            <div class="col-lg-4">
                <button type="button" class="btn btn-primary">搜索</button>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-lg-12">
                <table class="table table-striped table-hover" style="text-align: center;">
                <thead>
                    <tr>
                        <th>标题</th>
                        <th>作者</th>
                        <th>时间</th>
                        <th>阅读量</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="user in users" :key="user.id">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
            </div>

            <nav aria-label="...">
                <ul class="pagination" style="float: right;">
                    <li class="page-item" @click="click_page(-2)">
                        <a class="page-link" href="#">前一页</a>
                    </li>
                    <li :class="'page-item ' + page.is_active" v-for="page in pages" :key="page.number"
                        @click="click_page(page.number)">
                        <a class="page-link" href="#"></a>
                    </li>
                    <li class="page-item" @click="click_page(-1)">
                        <a class="page-link" href="#">后一页</a>
                    </li>
                </ul>
            </nav>
        </div>

    </ContentField>
</template>
<script>
import ContentField from '../../components/ContentField.vue';
import { useStore } from 'vuex';
import { ref } from 'vue';
import $ from 'jquery';
export default {
    components: {
        ContentField
    },
    setup() {
        
    }
}
</script>
<style scoped>
</style>