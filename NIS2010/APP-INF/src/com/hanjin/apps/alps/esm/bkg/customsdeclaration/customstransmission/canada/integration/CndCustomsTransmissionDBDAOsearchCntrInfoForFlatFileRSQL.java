/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchCntrInfoForFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.26
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.26 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchCntrInfoForFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrInfoForFlatFile
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchCntrInfoForFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchCntrInfoForFlatFileRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(BKG.BB_CGO_FLG, 'Y', 'BB', BKG.RCV_TERM_CD || BKG.DE_TERM_CD) AS RDTERM" ).append("\n"); 
		query.append("       ,CNTR.CNTR_TPSZ_CD 	AS CNTRTS" ).append("\n"); 
		query.append("       ,CNTR.CNTR_NO		AS CNTRNBR" ).append("\n"); 
		query.append("	   ,DECODE(CNTR.FULL_MTY_CD, 'M', 'E', 'L') AS LDMT" ).append("\n"); 
		query.append("  FROM  BKG_CSTMS_ADV_BL 	BL" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_CNTR  CNTR" ).append("\n"); 
		query.append("       ,BKG_BOOKING         BKG" ).append("\n"); 
		query.append(" WHERE  BL.CNT_CD 		= 'CA'" ).append("\n"); 
		query.append("   AND  BL.BL_NO		= @[bl_no]" ).append("\n"); 
		query.append("   AND  BL.CNT_CD		= CNTR.CNT_CD" ).append("\n"); 
		query.append("   AND  BL.BL_NO		= CNTR.BL_NO" ).append("\n"); 
		query.append("   AND  BL.BKG_NO		= BKG.BKG_NO" ).append("\n"); 
		query.append("   AND  CNTR.IBD_CNTR_STS_CD = 'A'" ).append("\n"); 

	}
}