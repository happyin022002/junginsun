/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOaddCustAdvisoryNoticeByUploadCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOaddCustAdvisoryNoticeByUploadCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * War, Vessel Damage, Vessel dealy 등 Emergemcy Case 가 발생 한 VVD 별 BL,Container 정보를 등록한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOaddCustAdvisoryNoticeByUploadCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOaddCustAdvisoryNoticeByUploadCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CUST_AVC_NTC_BL" ).append("\n"); 
		query.append(" ( SELECT  A.BL_NO         AS BL_NO" ).append("\n"); 
		query.append("          ,A.POL_CD" ).append("\n"); 
		query.append("          ,A.POD_CD" ).append("\n"); 
		query.append("          ,'N'              AS AVC_NTC_SND_FLG" ).append("\n"); 
		query.append("          ,@[cre_usr_id]    AS CRE_USR_ID" ).append("\n"); 
		query.append("          ,SYSDATE          AS CRE_DT" ).append("\n"); 
		query.append("          ,@[upd_usr_id]    AS UPD_USR_ID" ).append("\n"); 
		query.append("          ,SYSDATE          AS UPD_DT" ).append("\n"); 
		query.append("		  , 'E'			    AS SRC_DAT_TP_CD" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT DISTINCT BK.BKG_NO," ).append("\n"); 
		query.append("                            BK.BL_NO,                  " ).append("\n"); 
		query.append("                            BK.POL_CD," ).append("\n"); 
		query.append("                            BK.POD_CD" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("             FROM (" ).append("\n"); 
		query.append("                   SELECT DISTINCT BK.BKG_NO," ).append("\n"); 
		query.append("                           BK.BL_NO                   " ).append("\n"); 
		query.append("                   FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("                        BKG_VVD     BV" ).append("\n"); 
		query.append("                   WHERE BV.VSL_CD     = SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("                   AND   BV.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("                   AND   BV.SKD_DIR_CD IN (${dir_sts_cd})" ).append("\n"); 
		query.append("                   AND   BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("                   AND   BK.BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 		 	  AND NOT EXISTS (SELECT '*' FROM BKG_CUST_AVC_NTC_BL A" ).append("\n"); 
		query.append("									WHERE A.SRC_DAT_TP_CD = 'E'" ).append("\n"); 
		query.append("                				    AND A.BL_NO = BK.BL_NO" ).append("\n"); 
		query.append("                			      )" ).append("\n"); 
		query.append("             ) BV" ).append("\n"); 
		query.append("             , BKG_CUST_AVC_NTC_CNTR BC" ).append("\n"); 
		query.append("             , BKG_BOOKING BK" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("             AND   BC.BL_NO = BV.BL_NO" ).append("\n"); 
		query.append("             AND   BK.BL_NO = BV.BL_NO" ).append("\n"); 
		query.append("			 AND   BC.SRC_DAT_TP_CD = 'E'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}