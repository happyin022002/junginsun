/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchExportCntrInfoForFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.15 
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

public class CndCustomsTransmissionDBDAOsearchExportCntrInfoForFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 컨테이너 조회
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchExportCntrInfoForFlatFileRSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchExportCntrInfoForFlatFileRSQL").append("\n"); 
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
		query.append("#if (${mbl_no} == '')" ).append("\n"); 
		query.append("	SELECT C.CNTR_NO AS CNTRNBR" ).append("\n"); 
		query.append("	       ,C.CNTR_TPSZ_CD AS CNTRTS" ).append("\n"); 
		query.append("	       ,DECODE(B.BKG_CGO_TP_CD, 'F', 'L', 'M') AS LDMT           " ).append("\n"); 
		query.append("	  FROM  BKG_CONTAINER C" ).append("\n"); 
		query.append("	       ,BKG_BOOKING B" ).append("\n"); 
		query.append("	 WHERE  B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	   AND  C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	SELECT  DISTINCT C.CNTR_NO AS CNTRNBR" ).append("\n"); 
		query.append("	       ,C.CNTR_TPSZ_CD AS CNTRTS" ).append("\n"); 
		query.append("	       ,DECODE(B.BKG_CGO_TP_CD, 'F', 'L', 'M') AS LDMT      " ).append("\n"); 
		query.append("	  FROM  BKG_CONTAINER C" ).append("\n"); 
		query.append("	       ,BKG_BOOKING B" ).append("\n"); 
		query.append("	       ,BKG_CNTR_MF_DESC D" ).append("\n"); 
		query.append("	 WHERE  B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	   AND  C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	   AND  C.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("	   AND  C.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("	   AND  D.CNTR_MF_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}