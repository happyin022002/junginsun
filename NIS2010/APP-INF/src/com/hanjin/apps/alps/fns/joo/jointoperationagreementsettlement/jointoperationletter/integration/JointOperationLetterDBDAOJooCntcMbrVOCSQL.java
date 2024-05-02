/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationLetterDBDAOJooCntcMbrVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.02
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.12.02 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationLetterDBDAOJooCntcMbrVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  2010.11.08 이준범 [CHM-201006731-01]
	  *  1. 대상 기능
	  *    - JO Member Information Creation(JOO_0066)
	  *    - Inquiry of JO Member Information(JOO_0067)
	  *  2. 보완 대상
	  *    - Revenue Lane 정보 반영 
	  *    - MS Office( Excel, Worl, Power Point등) 첨부
	  *    - Carrier Name등 컬럼 반영
	  * 2010.12.02 이준범 [CHM-201007349-01]
	  * 1. 보완 기능 
	  *    - JO Member Information Creation
	  *    - Inquiry of JO Member Information
	  * 2. 보완 요청 사항
	  *    - 컬럼 추가 : PIC of HJS(ID),  Name of PIC,  RHQ, Office, Start Date,  Creation Date
	  * </pre>
	  */
	public JointOperationLetterDBDAOJooCntcMbrVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_cntc_pic_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_cntc_ofc_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_cntc_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_cntc_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_cntc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_in_chg_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOJooCntcMbrVOCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_CNTC_MBR(" ).append("\n"); 
		query.append("    JO_CRR_CD" ).append("\n"); 
		query.append("   ,CRR_CNTC_SEQ" ).append("\n"); 
		query.append("   ,CNTC_PSON_NM" ).append("\n"); 
		query.append("   ,SVC_IN_CHG_NM" ).append("\n"); 
		query.append("   ,JO_CNTC_PHN_NO" ).append("\n"); 
		query.append("   ,JO_CNTC_FAX_NO" ).append("\n"); 
		query.append("   ,JO_CNTC_EML" ).append("\n"); 
		query.append("   ,JO_CNTC_OFC_ADDR" ).append("\n"); 
		query.append("   ,RLANE_CD" ).append("\n"); 
		query.append("   ,JO_CNTC_PIC_ID" ).append("\n"); 
		query.append("   ,JO_CNTC_ST_DT" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("    @[jo_crr_cd]" ).append("\n"); 
		query.append("   ,(SELECT NVL(MAX(CRR_CNTC_SEQ) + 1, 1) FROM JOO_CNTC_MBR WHERE JO_CRR_CD = @[jo_crr_cd] )" ).append("\n"); 
		query.append("   ,@[cntc_pson_nm]" ).append("\n"); 
		query.append("   ,@[svc_in_chg_nm]" ).append("\n"); 
		query.append("   ,@[jo_cntc_phn_no]" ).append("\n"); 
		query.append("   ,@[jo_cntc_fax_no]" ).append("\n"); 
		query.append("   ,@[jo_cntc_eml]" ).append("\n"); 
		query.append("   ,@[jo_cntc_ofc_addr]" ).append("\n"); 
		query.append("   ,@[rlane_cd]" ).append("\n"); 
		query.append("   ,@[jo_cntc_pic_id]" ).append("\n"); 
		query.append("   ,NVL(@[jo_cntc_st_dt], TO_CHAR(SYSDATE, 'YYYYMMDD')) " ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append("   ,@[usr_id]" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append("   ,@[usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}