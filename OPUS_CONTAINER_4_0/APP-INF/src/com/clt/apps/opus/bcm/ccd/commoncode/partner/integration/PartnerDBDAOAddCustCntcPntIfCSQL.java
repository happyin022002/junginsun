/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PartnerDBDAOAddCustCntcPntIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.27 
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

public class PartnerDBDAOAddCustCntcPntIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Contract 정보 및 처리상태를 다른 시스템으로 전송하기 위해 저장한다.
	  * </pre>
	  */
	public PartnerDBDAOAddCustCntcPntIfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_phn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r3_insf_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cntc_pnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_url",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ip",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cntc_pnt_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r3_insf_dv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOAddCustCntcPntIfCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_CUST_CNTC_PNT_IF(" ).append("\n"); 
		query.append("             CUST_CNTC_PNT_IF_SEQ" ).append("\n"); 
		query.append("            ,CUST_CNT_CD  " ).append("\n"); 
		query.append("            ,CUST_SEQ" ).append("\n"); 
		query.append("            ,CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("            ,CUST_EML" ).append("\n"); 
		query.append("            ,CUST_IP" ).append("\n"); 
		query.append("            ,CUST_URL" ).append("\n"); 
		query.append("            ,INTL_PHN_NO" ).append("\n"); 
		query.append("            ,PHN_NO" ).append("\n"); 
		query.append("            ,INTL_FAX_NO" ).append("\n"); 
		query.append("            ,FAX_NO" ).append("\n"); 
		query.append("            ,R3_INSF_ID         " ).append("\n"); 
		query.append("            ,R3_INSF_DV_CD      " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    VALUES(  @[cust_cntc_pnt_if_seq]" ).append("\n"); 
		query.append("            ,@[cust_cnt_cd]" ).append("\n"); 
		query.append("            ,@[cust_seq]" ).append("\n"); 
		query.append("            ,@[cust_cntc_pnt_seq]" ).append("\n"); 
		query.append("            ,@[cust_eml]" ).append("\n"); 
		query.append("            ,@[cust_ip]" ).append("\n"); 
		query.append("            ,@[cust_url]" ).append("\n"); 
		query.append("            ,@[intl_phn_no]" ).append("\n"); 
		query.append("            ,@[phn_no]" ).append("\n"); 
		query.append("            ,@[intl_fax_no]" ).append("\n"); 
		query.append("            ,@[fax_no]" ).append("\n"); 
		query.append("            ,@[r3_insf_id]" ).append("\n"); 
		query.append("            ,@[r3_insf_dv_cd]" ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}