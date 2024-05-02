/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : IndonesiaCustomsTransmissionDBDAOSearchManifestContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndonesiaCustomsTransmissionDBDAOSearchManifestContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Indonesia 세관에 Manifest 신고할 내용을 download 받을 File로 생성하기 위해
	  * Container 정보를 조회한다. -- UI_BKG-0310, UI_BKG-0311
	  * </pre>
	  */
	public IndonesiaCustomsTransmissionDBDAOSearchManifestContainerListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.integration").append("\n"); 
		query.append("FileName : IndonesiaCustomsTransmissionDBDAOSearchManifestContainerListRSQL").append("\n"); 
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
		query.append("SELECT B.CNTR_NO," ).append("\n"); 
		query.append("  DECODE(SUBSTR(B.CNTR_TPSZ_CD, 2, 1), '2', '20', '4', '40', '5', '40', '7', '45', '  ') AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("#if (${bound_cd} == 'I') " ).append("\n"); 
		query.append("  DECODE(A.BKG_CGO_TP_CD, 'P', 'E', DECODE(A.DE_TERM_CD, 'S', 'L', 'F')) AS RCV_TERM_CD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  DECODE(A.BKG_CGO_TP_CD, 'P', 'E', DECODE(A.RCV_TERM_CD, 'S', 'L', 'F')) AS RCV_TERM_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  HD.ATTR_CTNT2 AS CNTR_TP," ).append("\n"); 
		query.append("  (SELECT MIN(CNTR_SEAL_NO) CNTR_SEAL_NO" ).append("\n"); 
		query.append("    FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("    WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      AND CNTR_NO = B.CNTR_NO ) CNTR_SEAL_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING A," ).append("\n"); 
		query.append("  BKG_CONTAINER B," ).append("\n"); 
		query.append("  BKG_CSTMS_CD_CONV_CTNT HD" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("  and HD.CNT_CD(+) = 'ID'" ).append("\n"); 
		query.append("  and HD.CSTMS_DIV_ID(+) = 'CNTR_TP_CD'" ).append("\n"); 
		query.append("  and b.CNTR_TPSZ_CD = HD.ATTR_CTNT1(+)" ).append("\n"); 

	}
}