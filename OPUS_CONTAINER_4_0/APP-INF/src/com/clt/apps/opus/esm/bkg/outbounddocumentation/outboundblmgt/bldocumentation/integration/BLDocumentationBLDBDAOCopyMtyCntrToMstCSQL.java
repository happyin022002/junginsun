/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLDBDAOCopyMtyCntrToMstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.17 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOCopyMtyCntrToMstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Split Bkg의 Container정보를 원본 Bkg의 Container정보에 Copy한다.
	  * </pre>
	  */
	public BLDocumentationBLDBDAOCopyMtyCntrToMstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("split_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOCopyMtyCntrToMstCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CONTAINER" ).append("\n"); 
		query.append("(BKG_NO," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNMV_CYC_NO," ).append("\n"); 
		query.append("CNMV_ID_NO," ).append("\n"); 
		query.append("CNMV_YR," ).append("\n"); 
		query.append("CNMV_STS_CD," ).append("\n"); 
		query.append("MCNTR_BDL_NO," ).append("\n"); 
		query.append("BDL_BTM_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append("SELECT @[bkg_no]," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNMV_CYC_NO," ).append("\n"); 
		query.append("CNMV_ID_NO," ).append("\n"); 
		query.append("CNMV_YR," ).append("\n"); 
		query.append("CNMV_STS_CD," ).append("\n"); 
		query.append("MCNTR_BDL_NO," ).append("\n"); 
		query.append("BDL_BTM_FLG," ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append("FROM   BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[split_bkg_no]" ).append("\n"); 
		query.append("AND    CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}