# Android-Final-Project-
This is an mobile application.

合作者方式比较实用，也很方便，新建一个Repository，完毕之后，进入Repository的Settings，然后在Manage Collaborators里就可以管理合作者了。
其他合作者，实用 ssh-keygen -C "YourEmail@example.com" （这里的email使用github账号）生成公钥和私钥，在Accounts Settings=》SSH keys 将公钥上传上去。
上传完成后，可使用Tower(Mac下Git管理工具）clone remote Repository  使用SSH方式登录（这里的私钥使用刚才生成的） 这样，其他合作者就可以正常的PUSH代码了。
