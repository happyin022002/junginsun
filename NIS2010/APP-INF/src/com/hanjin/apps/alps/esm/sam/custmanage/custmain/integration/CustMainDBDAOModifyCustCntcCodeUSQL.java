/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustMainDBDAOModifyCustCntcCodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOModifyCustCntcCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Update cust contact point
	  * </pre>
	  */
	public CustMainDBDAOModifyCustCntcCodeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("intl_phn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("phn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOModifyCustCntcCodeUSQL").append("\n"); 
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
		query.append("UPDATE MDM_CUST_CNTC_PNT" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("   CUST_EML          = @[cust_eml]" ).append("\n"); 
		query.append(",  CUST_IP           = @[cust_ip]" ).append("\n"); 
		query.append(",  CUST_URL          = @[cust_url]" ).append("\n"); 
		query.append(",  INTL_PHN_NO       = @[intl_phn_no]" ).append("\n"); 
		query.append(",  PHN_NO            = @[phn_no]" ).append("\n"); 
		query.append(",  INTL_FAX_NO       = @[intl_fax_no]" ).append("\n"); 
		query.append(",  FAX_NO            = @[fax_no]" ).append("\n"); 
		query.append(",  EAI_EVNT_DT		 = CASE WHEN NVL(CUST_EML,'0') <> NVL(@[cust_eml],'0') OR NVL(CUST_URL,'0') <> NVL(@[cust_url],'0') OR NVL(INTL_PHN_NO,'0') <> NVL(@[intl_phn_no],'0') " ).append("\n"); 
		query.append("								 OR NVL(PHN_NO,'0') <> NVL(@[phn_no],'0') OR NVL(INTL_FAX_NO,'0') <> NVL(@[intl_fax_no],'0') OR NVL(FAX_NO,'0') <> NVL(@[fax_no],'0')" ).append("\n"); 
		query.append("                            THEN SYSDATE" ).append("\n"); 
		query.append("							ELSE EAI_EVNT_DT" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("WHERE  CUST_CNT_CD    = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND CUST_SEQ          = @[cust_seq]" ).append("\n"); 
		query.append("AND CUST_CNTC_PNT_SEQ = 1" ).append("\n"); 

	}
}