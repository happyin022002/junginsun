/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOInsertSPContactPointCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOInsertSPContactPointCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SP Contact point 를 저장한다.
	  * </pre>
	  */
	public EacMgtDBDAOInsertSPContactPointCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_eml_use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psn_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_fax_use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_cntc_pnt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ste_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psn_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOInsertSPContactPointCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_EXPN_AUD_CS_CNTC_PNT(VNDR_SEQ" ).append("\n"); 
		query.append("                                  ,  VNDR_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("                                  ,  VNDR_CNTC_PNT_NM" ).append("\n"); 
		query.append("                                  ,  PSN_NM" ).append("\n"); 
		query.append("                                  ,  PSN_DESC" ).append("\n"); 
		query.append("                                  ,  STE_NM" ).append("\n"); 
		query.append("                                  ,  CTY_NM" ).append("\n"); 
		query.append("                                  ,  PHN_NO" ).append("\n"); 
		query.append("                                  ,  FAX_NO" ).append("\n"); 
		query.append("                                  ,  VNDR_EML" ).append("\n"); 
		query.append("                                  ,  EAC_EML_USE_FLG" ).append("\n"); 
		query.append("                                  ,  EAC_FAX_USE_FLG" ).append("\n"); 
		query.append("                                  ,  DELT_FLG" ).append("\n"); 
		query.append("                                  ,  CRE_USR_ID" ).append("\n"); 
		query.append("                                  ,  CRE_DT" ).append("\n"); 
		query.append("                                  ,  UPD_USR_ID" ).append("\n"); 
		query.append("                                  ,  UPD_DT" ).append("\n"); 
		query.append("                                  )VALUES(" ).append("\n"); 
		query.append("                                     @[vndr_seq]" ).append("\n"); 
		query.append("                                  ,  NVL((SELECT /*+ index_desc(A XPKEAS_EXPN_AUD_CS_CNTC_PNT) */ VNDR_CNTC_PNT_SEQ FROM EAS_EXPN_AUD_CS_CNTC_PNT A where VNDR_SEQ = @[vndr_seq] AND rownum=1),0)+1 " ).append("\n"); 
		query.append("                                  ,  @[vndr_cntc_pnt_nm]" ).append("\n"); 
		query.append("                                  ,  @[psn_nm]" ).append("\n"); 
		query.append("                                  ,  @[psn_desc]" ).append("\n"); 
		query.append("                                  ,  @[ste_nm]" ).append("\n"); 
		query.append("                                  ,  @[cty_nm]" ).append("\n"); 
		query.append("                                  ,  @[phn_no]" ).append("\n"); 
		query.append("                                  ,  @[fax_no]" ).append("\n"); 
		query.append("                                  ,  @[vndr_eml]" ).append("\n"); 
		query.append("                                  ,  decode(@[eac_eml_use_flg],0,'N',1,'Y')" ).append("\n"); 
		query.append("                                  ,  decode(@[eac_fax_use_flg],0,'N',1,'Y')" ).append("\n"); 
		query.append("                                  ,  @[delt_flg]" ).append("\n"); 
		query.append("                                  ,  @[cre_usr_id]" ).append("\n"); 
		query.append("                                  ,  sysdate" ).append("\n"); 
		query.append("                                  ,  @[upd_usr_id]" ).append("\n"); 
		query.append("                                  ,  sysdate                                  " ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}