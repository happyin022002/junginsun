/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchExportSealNoInfoForFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchExportSealNoInfoForFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchExportSealNoInfoForFlatFileRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchExportSealNoInfoForFlatFileRSQL").append("\n"); 
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
		query.append("#if (${mbl_no} == '') " ).append("\n"); 
		query.append("	SELECT CNTR_SEAL_NO AS SEAL_NO" ).append("\n"); 
		query.append("	  FROM  BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("	 WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("       AND  CNTR_NO	= @[cntr_no]" ).append("\n"); 
		query.append("       AND TRIM(CNTR_SEAL_NO) != '-'  /*제외*/" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	SELECT DISTINCT S.CNTR_SEAL_NO AS SEAL_NO" ).append("\n"); 
		query.append("	  FROM  BKG_CNTR_SEAL_NO S" ).append("\n"); 
		query.append("	       ,BKG_CNTR_MF_DESC D" ).append("\n"); 
		query.append("	 WHERE  S.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	   AND  S.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("	   AND  S.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("	   AND  D.CNTR_MF_NO = @[bl_no]" ).append("\n"); 
		query.append("       AND  S.CNTR_NO	= @[cntr_no]" ).append("\n"); 
		query.append("       AND TRIM(S.CNTR_SEAL_NO) != '-'  /*제외*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}