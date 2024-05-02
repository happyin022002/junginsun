/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PartnerDBDAOMergeMdmCustFrmVndrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOMergeMdmCustFrmVndrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PartnerDBDAOMergeMdmCustFrmVndrCSQL
	  * </pre>
	  */
	public PartnerDBDAOMergeMdmCustFrmVndrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_locl_lang_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOMergeMdmCustFrmVndrCSQL").append("\n"); 
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
		query.append("MERGE INTO MDM_CUSTOMER A" ).append("\n"); 
		query.append(" USING ( SELECT @[cust_cnt_cd] CUST_CNT_CD, @[cust_seq] CUST_SEQ FROM DUAL ) B" ).append("\n"); 
		query.append(" ON (A.CUST_CNT_CD = B.CUST_CNT_CD AND A.CUST_SEQ = B.CUST_SEQ )" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append(" UPDATE SET" ).append("\n"); 
		query.append("	  CNTR_DIV_FLG = 'Y'," ).append("\n"); 
		query.append("	  BLK_DIV_FLG = 'N'," ).append("\n"); 
		query.append("	  UPD_USR_ID  = @[upd_usr_id]," ).append("\n"); 
		query.append("	  UPD_DT      = SYSDATE," ).append("\n"); 
		query.append("	  CUST_RGST_NO = @[cust_rgst_no]," ).append("\n"); 
		query.append("	  CUST_LGL_ENG_NM  = SUBSTRB(@[cust_lgl_eng_nm], 1, 100)," ).append("\n"); 
		query.append("	  CUST_LOCL_LANG_NM  = @[cust_locl_lang_nm]," ).append("\n"); 
		query.append("	  DELT_FLG = DECODE(NVL(@[ib_flag], 'U'), 'D', 'Y', 'N')" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append(" INSERT" ).append("\n"); 
		query.append("	 (" ).append("\n"); 
		query.append("		  CUST_CNT_CD," ).append("\n"); 
		query.append("		  CUST_SEQ," ).append("\n"); 
		query.append("		  CNTR_DIV_FLG," ).append("\n"); 
		query.append("		  BLK_DIV_FLG," ).append("\n"); 
		query.append("		  CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("		  CUST_LOCL_LANG_NM," ).append("\n"); 
		query.append("		  OFC_CD," ).append("\n"); 
		query.append("		  CUST_RGST_NO," ).append("\n"); 
		query.append("		  LOC_CD," ).append("\n"); 
		query.append("		  VNDR_SEQ," ).append("\n"); 
		query.append("		  MODI_CUST_CNT_CD," ).append("\n"); 
		query.append("		  MODI_CUST_SEQ," ).append("\n"); 
		query.append("		  CRE_USR_ID," ).append("\n"); 
		query.append("		  CRE_DT," ).append("\n"); 
		query.append("		  UPD_USR_ID," ).append("\n"); 
		query.append("		  UPD_DT," ).append("\n"); 
		query.append("		  DELT_FLG" ).append("\n"); 
		query.append("	 )" ).append("\n"); 
		query.append("	 VALUES" ).append("\n"); 
		query.append("	 (" ).append("\n"); 
		query.append("		  @[cust_cnt_cd]," ).append("\n"); 
		query.append("		  @[cust_seq]," ).append("\n"); 
		query.append("		  'Y'," ).append("\n"); 
		query.append("		  'N'," ).append("\n"); 
		query.append("		  SUBSTRB(@[cust_lgl_eng_nm], 1, 100)," ).append("\n"); 
		query.append("		  @[cust_locl_lang_nm]," ).append("\n"); 
		query.append("		  @[ofc_cd]," ).append("\n"); 
		query.append("		  @[cust_rgst_no]," ).append("\n"); 
		query.append("		  @[loc_cd]," ).append("\n"); 
		query.append("		  @[vndr_seq]," ).append("\n"); 
		query.append("		  @[modi_cust_cnt_cd]," ).append("\n"); 
		query.append("		  @[modi_cust_seq]," ).append("\n"); 
		query.append("		  @[cre_usr_id]," ).append("\n"); 
		query.append("		  SYSDATE," ).append("\n"); 
		query.append("		  @[upd_usr_id]," ).append("\n"); 
		query.append("		  SYSDATE," ).append("\n"); 
		query.append("		  'N'" ).append("\n"); 
		query.append("	 )" ).append("\n"); 

	}
}