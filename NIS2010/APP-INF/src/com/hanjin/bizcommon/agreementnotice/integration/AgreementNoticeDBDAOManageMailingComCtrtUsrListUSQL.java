/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementNoticeDBDAOManageMailingComCtrtUsrListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.agreementnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementNoticeDBDAOManageMailingComCtrtUsrListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * usr list 정보를 조회해서 있으면 update하고 없으면 insert한다
	  * </pre>
	  */
	public AgreementNoticeDBDAOManageMailingComCtrtUsrListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_usr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_usr_id_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.agreementnotice.integration").append("\n"); 
		query.append("FileName : AgreementNoticeDBDAOManageMailingComCtrtUsrListUSQL").append("\n"); 
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
		query.append("MERGE INTO COM_CTRT_USR_LIST P" ).append("\n"); 
		query.append("USING  DUAL" ).append("\n"); 
		query.append("ON (P.SYS_CD = @[sys_cd] AND P.CTRT_OFC_CD = @[ctrt_ofc_cd] AND P.AGMT_NO = NVL(@[agmt_no],'ALL') AND P.NTC_USR_SEQ = @[ntc_usr_seq])" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET" ).append("\n"); 
		query.append("		P.NTC_USR_ID = @[ntc_usr_id]," ).append("\n"); 
		query.append("        P.NTC_USR_ID_JB_CD = @[ntc_usr_id_jb_cd]," ).append("\n"); 
		query.append("        P.UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("        P.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("        SYS_CD," ).append("\n"); 
		query.append("        CTRT_OFC_CD," ).append("\n"); 
		query.append("        AGMT_NO," ).append("\n"); 
		query.append("        NTC_USR_SEQ," ).append("\n"); 
		query.append("        NTC_USR_ID," ).append("\n"); 
		query.append("        NTC_USR_ID_JB_CD,        " ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT" ).append("\n"); 
		query.append("    ) VALUES (" ).append("\n"); 
		query.append("        @[sys_cd], --SYS_CD" ).append("\n"); 
		query.append("        @[ctrt_ofc_cd], --CTRT_OFC_CD," ).append("\n"); 
		query.append("        NVL(@[agmt_no],'ALL'), --AGMT_NO" ).append("\n"); 
		query.append("        @[ntc_usr_seq], --NTC_USR_SEQ" ).append("\n"); 
		query.append("        @[ntc_usr_id], --NTC_USR_ID" ).append("\n"); 
		query.append("        @[ntc_usr_id_jb_cd], --NTC_USR_ID_JB_CD" ).append("\n"); 
		query.append("        @[cre_usr_id], --CRE_USR_ID," ).append("\n"); 
		query.append("        SYSDATE, --CRE_DT" ).append("\n"); 
		query.append("        @[upd_usr_id], --UPD_USR_ID," ).append("\n"); 
		query.append("        SYSDATE  --UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}