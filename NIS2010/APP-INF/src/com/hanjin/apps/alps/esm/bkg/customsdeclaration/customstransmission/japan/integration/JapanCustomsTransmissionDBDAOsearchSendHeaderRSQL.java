/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JapanCustomsTransmissionDBDAOsearchSendHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsTransmissionDBDAOsearchSendHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSendHeader
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchSendHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_data",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_length",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_msg_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchSendHeaderRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${in_msg_tp} == 'DOR' )" ).append("\n"); 
		query.append("    'JANCUS'||RPAD(' ',9,' ')||RPAD((SELECT DEL_CD FROM BKG_BOOKING WHERE BL_NO = @[bl_no]),5,' ')||" ).append("\n"); 
		query.append("       RPAD(UPPER(@[ofc_cd]),6,' ')||RPAD(UPPER(@[usr_id]),10,' ')||" ).append("\n"); 
		query.append("       SUBSTR(LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'000009'),' '),2)||" ).append("\n"); 
		query.append("       TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS')||" ).append("\n"); 
		query.append("      'DOR  '||'                    '			HEADER," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	'JANCUS'||RPAD(@[in_vvd_cd],9,' ')||RPAD(@[in_pod_cd],5,' ')||" ).append("\n"); 
		query.append("	RPAD(@[ofc_cd],6,' ')||RPAD(UPPER(@[usr_id]),10,' ')||" ).append("\n"); 
		query.append("	SUBSTR(LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'000009'),' '),2)||" ).append("\n"); 
		query.append("#if (${date_data}!= '') " ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(@[date_data],'YYYY-MM-DD HH24:MI:SS'),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("RPAD(TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS'),14,' ')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("||RPAD(@[in_msg_tp],5,' ')||'                    ' HEADER," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    '   '||RPAD(@[in_msg_tp],5,' ')||RPAD(' ',21,' ')||" ).append("\n"); 
		query.append("    'JJ54O001SMLM25  '|| -- 공백 포함16자리" ).append("\n"); 
		query.append("	--DECODE(null,'D','1ADSN','1ASLD')||'C0A'|| --'1ASA2001'||" ).append("\n"); 
		query.append("	--DECODE(null,'D','KDMEG8SV','2FHJERGN')|| --'NACCSTST'|| " ).append("\n"); 
		query.append("	RPAD(' ',174,' ')||RPAD(' ',26,' ')||" ).append("\n"); 
		query.append("	RPAD(' ',8,' ')||UPPER(RPAD(@[usr_id],10,' '))||" ).append("\n"); 
		query.append("	RPAD(' ',100,' ')||RPAD(' ',1,' ')||" ).append("\n"); 
		query.append("	'2'||RPAD(' ',27,' ')||LPAD((@[str_length] + 400),6,'0') HEADER2" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	DUAL" ).append("\n"); 

	}
}