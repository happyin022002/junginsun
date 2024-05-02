/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchTsMrnNumberRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchTsMrnNumberRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eu 내 TS 한 경우 이전 VVD 의 MRN 을 가져온다.
	  * 
	  * VVD POL : 유럽 (CONTI_CD = 'E')
	  * BKG POD : 유럽 (CONTI_CD = 'E')
	  * 
	  * 검색하는 vvd_cd : Frontend 에서 넘겨받은 VVD 정보를 이용해서, 
	  * BKG_VVD 에서 하나의 BKG_NO 에 물려있으면서,
	  * 이전 항차에 대한 정보를 조회함 
	  * (이전항차 POD = 검색파라미터 항차 POL // 동일한 BKG_NO )
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchTsMrnNumberRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchTsMrnNumberRSQL").append("\n"); 
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
		query.append("SELECT POFE,MRN,POFE_ETA FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT EUBL1.CSTMS_PORT_CD POFE, EUBL1.MVMT_REF_NO MRN , NVL(TO_CHAR(EUBL1.CSTMS_ESTM_ARR_DT ,'YYYY-MM-DD HH24:MI'),' ') POFE_ETA, EUBL1.CRE_DT" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_EUR_BL EUBL1, BKG_CSTMS_EUR_BL EUBL2, BKG_BOOKING BB, BKG_VVD BV " ).append("\n"); 
		query.append("    WHERE BV.VSL_CD = SUBSTR(@[vvd_cd],1,4)  " ).append("\n"); 
		query.append("    AND BV.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)  " ).append("\n"); 
		query.append("    AND BV.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)  " ).append("\n"); 
		query.append("    AND EUBL1.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("    AND BV.POD_CD  = @[pod_cd]" ).append("\n"); 
		query.append("    AND BV.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("    AND EUBL1.BL_NO = BB.BL_NO" ).append("\n"); 
		query.append("    AND EUBL1.VSL_CD||EUBL1.SKD_VOY_NO||EUBL1.SKD_DIR_CD = (" ).append("\n"); 
		query.append("  															   SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD " ).append("\n"); 
		query.append("                                                               FROM BKG_VVD " ).append("\n"); 
		query.append("                                                               WHERE BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                                                               AND POD_CD = BV.POL_CD" ).append("\n"); 
		query.append("															)" ).append("\n"); 
		query.append("    AND EUBL2.VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("    AND EUBL2.SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND EUBL2.SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND EUBL2.BL_NO = BB.BL_NO" ).append("\n"); 
		query.append("    AND BB.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("    AND SUBSTR(BV.POL_CD, 1,2) IN (SELECT CC.ATTR_CTNT1" ).append("\n"); 
		query.append("                               FROM BKG_CSTMS_CD_CONV_CTNT CC" ).append("\n"); 
		query.append("                               WHERE CC.CSTMS_DIV_ID = 'EU_MEMBER_CNT'" ).append("\n"); 
		query.append("                                AND CC.CNT_CD  = 'EU'" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("    AND SUBSTR(BV.POD_CD, 1,2) IN (SELECT CC.ATTR_CTNT1" ).append("\n"); 
		query.append("                               FROM BKG_CSTMS_CD_CONV_CTNT CC" ).append("\n"); 
		query.append("                               WHERE CC.CSTMS_DIV_ID = 'EU_MEMBER_CNT'" ).append("\n"); 
		query.append("                                AND CC.CNT_CD  = 'EU'" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                               " ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}