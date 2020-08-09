# awk demo
# 搜索/etc/passwd有root关键字的所有行，并显示对应的shel
awk -F : '/root/{print $7}'  /etc/passwd

