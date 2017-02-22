TextWatcher textWatcher=new TextWatcher(){
@Override
public void beforeTextChanged(CharSequence s,int start,int count,int after){
        }

@Override
public void onTextChanged(CharSequence s,int start,int before,int count){
        mStringBuilder=new StringBuilder(editTextMobile.getText());
        mStringBuilder=AndroidAppUtil.formatMobileNumber(mStringBuilder);
        editTextMobile.removeTextChangedListener(textWatcher);
        editTextMobile.setText(mStringBuilder.toString());
        editTextMobile.setSelection(mStringBuilder.length());
        editTextMobile.addTextChangedListener(textWatcher);
        }

@Override
public void afterTextChanged(Editable s){
        }
public static StringBuilder formatMobileNumber(StringBuilder stringBuilder){
        StringBuilder formatMobileNumber=new StringBuilder();
        char[]chars=stringBuilder.toString().replaceAll("\\W","").toCharArray();
        if(chars.length<=10){
        for(int i=0;i<chars.length;i++){
        if(i==3){
        formatMobileNumber.insert(3,"-");
        formatMobileNumber.append(chars[i]);
        }else if(i==7){
        formatMobileNumber.deleteCharAt(3);
        formatMobileNumber.insert(3," ").insert(0,"(").insert(4,")");
        formatMobileNumber.append(chars[i]);
        }else if(i==8){
        formatMobileNumber.insert(9,"-");
        formatMobileNumber.append(chars[i]);
        }else{
        formatMobileNumber.append(chars[i]);
        }
        }
        }else{
        if(chars.length==12){
        return stringBuilder.insert(0,"(").insert(3,")").insert(4," ");
        }
        return new StringBuilder(stringBuilder.toString().replaceAll("\\W",""));
        }
        return formatMobileNumber;
        }
        };