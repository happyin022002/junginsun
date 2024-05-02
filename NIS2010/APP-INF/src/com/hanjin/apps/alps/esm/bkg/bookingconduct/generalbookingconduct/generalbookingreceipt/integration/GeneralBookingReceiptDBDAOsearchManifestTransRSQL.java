/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOsearchManifestTransRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOsearchManifestTransRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 변경시 사전신고 된 VVD가 변경된 경우 저장 Click시 warning 메시지 표시
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOsearchManifestTransRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOsearchManifestTransRSQL").append("\n"); 
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
		query.append("SELECT BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("SELECT SYS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DECODE(SND.CNT_CD, 'CA', 'ACI', 'AMS') AS SYS ," ).append("\n"); 
		query.append("SND.VSL_CD ," ).append("\n"); 
		query.append("SND.SKD_VOY_NO ," ).append("\n"); 
		query.append("SND.SKD_DIR_CD ," ).append("\n"); 
		query.append("ROW_NUMBER() OVER (PARTITION BY SND.CNT_CD" ).append("\n"); 
		query.append("ORDER BY SND.CRE_DT DESC) RN" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_BL SND" ).append("\n"); 
		query.append("WHERE SND.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'ENS' ," ).append("\n"); 
		query.append("SND.VSL_CD ," ).append("\n"); 
		query.append("SND.SKD_VOY_NO ," ).append("\n"); 
		query.append("SND.SKD_DIR_CD ," ).append("\n"); 
		query.append("ROW_NUMBER() OVER (" ).append("\n"); 
		query.append("ORDER BY SND.CRE_DT DESC) RN" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG ," ).append("\n"); 
		query.append("BKG_CSTMS_ADV_EUR_SND SND" ).append("\n"); 
		query.append("WHERE BKG.BL_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG.BL_NO = SND.BL_NO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'CCAM' ," ).append("\n"); 
		query.append("SND.VSL_CD ," ).append("\n"); 
		query.append("SND.SKD_VOY_NO ," ).append("\n"); 
		query.append("SND.SKD_DIR_CD ," ).append("\n"); 
		query.append("ROW_NUMBER() OVER (" ).append("\n"); 
		query.append("ORDER BY SND.CRE_DT DESC) RN" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG ," ).append("\n"); 
		query.append("BKG_CSTMS_CHN_SND_LOG_BL BL ," ).append("\n"); 
		query.append("BKG_CSTMS_CHN_SND_LOG SND" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG.BL_NO = BL.BL_NO" ).append("\n"); 
		query.append("AND BL.EDI_REF_ID = SND.EDI_REF_ID ) SND_LOG ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD" ).append("\n"); 
		query.append("FROM BKG_VVD" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if ($vvds.size() > 0)" ).append("\n"); 
		query.append("AND VSL_CD||SKD_VOY_NO||SKD_DIR_CD NOT IN (" ).append("\n"); 
		query.append("#foreach($vvd IN ${vvds})" ).append("\n"); 
		query.append("#if($velocityCount < $vvds.size()) '$vvd', #else '$vvd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")) VVD_CHK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE SND_LOG.RN = 1" ).append("\n"); 
		query.append("AND SND_LOG.VSL_CD = VVD_CHK.VSL_CD" ).append("\n"); 
		query.append("AND SND_LOG.SKD_VOY_NO = VVD_CHK.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SND_LOG.SKD_DIR_CD = VVD_CHK.SKD_DIR_CD ) , ' / ') AS VVD_CHANGE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}