/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchMsnByBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchMsnByBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MSN 정보 조회
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchMsnByBkgRSQL(){
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
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchMsnByBkgRSQL").append("\n"); 
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
		query.append("--BND_CD = I" ).append("\n"); 
		query.append("SELECT NVL(MRN_BL_TS_CD, ' ') BLTS" ).append("\n"); 
		query.append("       , NVL(KR_CSTMS_BL_TP_CD, ' ') BLTP" ).append("\n"); 
		query.append("       , NVL(MF_SEQ_NO, ' ') MSN_NBR" ).append("\n"); 
		query.append("       , DECODE(MF_CFM_FLG, 'Y', 'Y', 'N') MSNCFM" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_KR_MF_SEQ_NO" ).append("\n"); 
		query.append(" WHERE BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("   AND MF_REF_NO = SUBSTR(@[mrn_no], 1, 10)" ).append("\n"); 
		query.append("   AND MRN_BL_TS_CD IN ('I', 'T')" ).append("\n"); 
		query.append("   AND MF_SEQ_NO IS NOT NULL" ).append("\n"); 
		query.append("   AND 'I' = @[bnd_cd]" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- BND_CD = O" ).append("\n"); 
		query.append("SELECT NVL(MRN_BL_TS_CD, ' ') BLTS" ).append("\n"); 
		query.append("       , NVL(KR_CSTMS_BL_TP_CD, ' ') BLTP" ).append("\n"); 
		query.append("       , NVL(MF_SEQ_NO, ' ') MSN_NBR" ).append("\n"); 
		query.append("       , DECODE(MF_CFM_FLG, 'Y', 'Y', 'N') MSNCFM" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_KR_MF_SEQ_NO" ).append("\n"); 
		query.append(" WHERE BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("   AND MRN_BL_TS_CD IN ('T')" ).append("\n"); 
		query.append("   AND MF_SEQ_NO IS NOT NULL" ).append("\n"); 
		query.append("   AND 'O' = @[bnd_cd]" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}