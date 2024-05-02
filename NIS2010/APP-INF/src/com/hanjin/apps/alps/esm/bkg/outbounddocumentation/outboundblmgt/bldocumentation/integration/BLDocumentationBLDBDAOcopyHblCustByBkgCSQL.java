/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLDBDAOcopyHblCustByBkgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.10.14 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOcopyHblCustByBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public BLDocumentationBLDBDAOcopyHblCustByBkgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetBkg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOcopyHblCustByBkgCSQL").append("\n"); 
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
		query.append("insert into bkg_hbl_cust" ).append("\n"); 
		query.append("(BKG_NO" ).append("\n"); 
		query.append(", HBL_SEQ" ).append("\n"); 
		query.append(", BKG_CUST_TP_CD" ).append("\n"); 
		query.append(", CUST_CNT_CD" ).append("\n"); 
		query.append(", CUST_SEQ" ).append("\n"); 
		query.append(", CUST_NM" ).append("\n"); 
		query.append(", CUST_ADDR" ).append("\n"); 
		query.append(", CUST_ZIP_ID" ).append("\n"); 
		query.append(", CTY_NM" ).append("\n"); 
		query.append(", STE_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT)" ).append("\n"); 
		query.append("select @[targetBkg] BKG_NO" ).append("\n"); 
		query.append(", hcust.HBL_SEQ + (SELECT NVL(MAX(hbl_seq), 0)" ).append("\n"); 
		query.append("FROM bkg_hbl_cust" ).append("\n"); 
		query.append("WHERE bkg_no = @[targetBkg])" ).append("\n"); 
		query.append(", hcust.BKG_CUST_TP_CD" ).append("\n"); 
		query.append(", hcust.CUST_CNT_CD" ).append("\n"); 
		query.append(", hcust.CUST_SEQ" ).append("\n"); 
		query.append(", hcust.CUST_NM" ).append("\n"); 
		query.append(", hcust.CUST_ADDR" ).append("\n"); 
		query.append(", hcust.CUST_ZIP_ID" ).append("\n"); 
		query.append(", hcust.CTY_NM" ).append("\n"); 
		query.append(", hcust.STE_CD" ).append("\n"); 
		query.append(", @[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(", sysdate CRE_DT" ).append("\n"); 
		query.append(", @[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(", sysdate UPD_DT" ).append("\n"); 
		query.append("from bkg_hbl_cust hcust" ).append("\n"); 
		query.append("where hcust.bkg_no = @[bkg_no]" ).append("\n"); 

	}
}