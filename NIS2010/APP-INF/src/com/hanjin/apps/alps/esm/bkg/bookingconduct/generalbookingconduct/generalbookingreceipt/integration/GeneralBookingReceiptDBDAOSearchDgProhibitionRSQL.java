/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchDgProhibitionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.08 
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

public class GeneralBookingReceiptDBDAOSearchDgProhibitionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingReceiptDBDAOSearchDgProhibitionRSQL
	  * 
	  * 15.04.08 [CHM-201534951] [Turkey] 위험물 관련 Restriction message 수정
	  *           -  China 로 제한된 POL 조건을 없애고, 
	  *              IMDG_CLSS_CD IN ('2.1', '2.2', '2.3', '5.1', '5.2', '6.2') 경우로 제한
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchDgProhibitionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchDgProhibitionRSQL").append("\n"); 
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
		query.append("SELECT B.ATTR_CTNT6" ).append("\n"); 
		query.append("  FROM BKG_HRD_CDG_CTNT B" ).append("\n"); 
		query.append(" WHERE B.HRD_CDG_ID = 'DG_MARMARA_SEA'" ).append("\n"); 
		query.append("--   AND [bkg_pol_cd] LIKE B.ATTR_CTNT1 || '%'" ).append("\n"); 
		query.append("   AND @[bkg_pod_cd] = B.ATTR_CTNT2" ).append("\n"); 
		query.append("   AND B.ATTR_CTNT10 = 'Y'" ).append("\n"); 
		query.append("   AND @[dcgo_flg] = 'Y'" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 1 " ).append("\n"); 
		query.append("#if(${ca_flg} == 'Y')" ).append("\n"); 
		query.append("                 FROM BKG_DG_CGO_HIS " ).append("\n"); 
		query.append("                WHERE CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                 FROM BKG_DG_CGO" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                  AND IMDG_CLSS_CD IN ('2.1', '2.2', '2.3', '5.1', '5.2', '6.2')" ).append("\n"); 
		query.append("              )" ).append("\n"); 

	}
}