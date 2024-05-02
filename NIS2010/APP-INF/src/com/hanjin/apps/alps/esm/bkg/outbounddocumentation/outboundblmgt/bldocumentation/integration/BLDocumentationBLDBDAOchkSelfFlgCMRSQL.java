/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOchkSelfFlgCMRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOchkSelfFlgCMRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CM에서 Self 가 있는지 없는지 구분
	  * </pre>
	  */
	public BLDocumentationBLDBDAOchkSelfFlgCMRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOchkSelfFlgCMRSQL").append("\n"); 
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
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("FROM BKG_BKG_HIS BKG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND BKG.POD_CD LIKE 'US%'" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("AND BKG.CORR_NO = (SELECT MAX(CORR_NO) FROM BKG_BKG_HIS WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("AND EXISTS (SELECT 1 FROM bkg_cntr_mf_desc_his WHERE BKG_NO = BKG.BKG_NO AND CNTR_MF_NO = 'SELF' AND CORR_NO = (SELECT MAX(CORR_NO) FROM bkg_cntr_mf_desc_his WHERE BKG_NO = @[bkg_no]) AND ROWNUM = 1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND EXISTS (SELECT 1 FROM bkg_cntr_mf_desc WHERE BKG_NO = BKG.BKG_NO AND CNTR_MF_NO = 'SELF' AND ROWNUM = 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}