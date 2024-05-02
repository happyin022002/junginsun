/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLDocumentationCMDBDAOModifyCrdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.07
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.01.07 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOModifyCrdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cargo Receive Date Update
	  * </pre>
	  */
	public BLDocumentationCMDBDAOModifyCrdUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOModifyCrdUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CONTAINER CNTR " ).append("\n"); 
		query.append("   SET CGO_RCV_DT = CASE " ).append("\n"); 
		query.append("					WHEN CGO_RCV_DT IS NULL THEN (SELECT MIN(MVMT.CNMV_EVNT_DT) AS CGO_RCV_DT" ).append("\n"); 
		query.append("                       FROM CTM_MOVEMENT MVMT" ).append("\n"); 
		query.append("                      WHERE MVMT.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                        AND MVMT.MVMT_STS_CD = 'OC'" ).append("\n"); 
		query.append("                        --AND MVMT.CNMV_YR = CNTR.CNMV_YR" ).append("\n"); 
		query.append("                        AND MVMT.CNMV_CYC_NO = CNTR.CNMV_CYC_NO                     " ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("					ELSE CGO_RCV_DT " ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}