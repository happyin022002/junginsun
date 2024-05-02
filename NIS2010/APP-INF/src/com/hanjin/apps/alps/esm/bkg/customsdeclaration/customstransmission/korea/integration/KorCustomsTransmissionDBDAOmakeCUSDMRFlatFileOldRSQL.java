/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeCUSDMRFlatFileOldRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOmakeCUSDMRFlatFileOldRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CUSDMR
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeCUSDMRFlatFileOldRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_disc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_cstms_dept_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_disc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_amd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_name",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOmakeCUSDMRFlatFileOldRSQL").append("\n"); 
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
		query.append("SELECT  '5LK'                             ||'~'|| /*  Message Code        */" ).append("\n"); 
		query.append("        TO_CHAR(@[cstms_ofc_cty_cd],'FM000')          ||'~'|| /*  신고세관            */" ).append("\n"); 
		query.append("        TO_CHAR(@[kr_cstms_dept_cd],'FM00')          ||'~'|| /*  신고세관과          */" ).append("\n"); 
		query.append("        @[smt_amd_no]                     ||'~'|| /*  Submit No.          */" ).append("\n"); 
		query.append("        DECODE(@[old_disc],null,'2','1')  ||'~'|| /* 전송모드 1:정정, 2:추가 */" ).append("\n"); 
		query.append("        TO_CHAR(SYSDATE,'YYYYMMDD')       ||'~'|| /*  전송 Date           */        " ).append("\n"); 
		query.append("        @[trns_seq]                       ||'~'|| /* 차수                 */" ).append("\n"); 
		query.append("        @[corr_rsn]                       ||'~'|| /* 정정사유             */" ).append("\n"); 
		query.append("        @[old_disc]                       ||'~'|| /* 정정전 하선장소      */" ).append("\n"); 
		query.append("        @[new_disc]                       ||'~'|| /* 정정후 하선장소      */" ).append("\n"); 
		query.append("        SUBSTR(@[usr_name],1,35)                  /*  정정 신청자 성명    */" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}