/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchEurTroNoticeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.30 
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

public class GeneralBookingSearchDBDAOSearchEurTroNoticeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sent TRO Notice history 조회
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchEurTroNoticeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchEurTroNoticeRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(FAX XPKBKG_NTC_HIS) INDEX_DESC(EML XPKBKG_NTC_HIS) */" ).append("\n"); 
		query.append("DECODE(@[io_bnd_cd], 'O', 'HO', 'HI') NTC_KND_CD" ).append("\n"); 
		query.append(", FAX.NTC_FAX_NO FAX_NO" ).append("\n"); 
		query.append(", FAX.SND_USR_ID FAX_SENDER" ).append("\n"); 
		query.append(", (SELECT USR_NM FROM COM_USER USR WHERE USR.USR_ID = FAX.SND_USR_ID) FAX_SENDER_NM" ).append("\n"); 
		query.append(", NVL ((SELECT XPT_DT FROM COM_FAX_SND_INFO WHERE FAX_SND_NO = FAX.SND_ID)," ).append("\n"); 
		query.append("NVL ((SELECT UPD_DT FROM COM_FAX_SND_INFO WHERE FAX_SND_NO = FAX.SND_ID)," ).append("\n"); 
		query.append("FAX.SND_RQST_DT)) AS FAX_SEND_DT" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE 'CD02396' = INTG_CD_ID" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT =" ).append("\n"); 
		query.append("NVL2((SELECT FAX_PROC_STS_CD" ).append("\n"); 
		query.append("FROM COM_FAX_SND_INFO" ).append("\n"); 
		query.append("WHERE FAX_SND_NO = FAX.SND_ID)," ).append("\n"); 
		query.append("DECODE((SELECT FAX_PROC_STS_CD" ).append("\n"); 
		query.append("FROM COM_FAX_SND_INFO" ).append("\n"); 
		query.append("WHERE FAX_SND_NO = FAX.SND_ID),1,2,2,2,3,2,4,2,5,3,6,4,1)," ).append("\n"); 
		query.append("NVL2(FAX.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("DECODE(FAX.BKG_NTC_SND_RSLT_CD,4,2,5,3,6,4,1),1))) AS FAX_SEND_RESULT" ).append("\n"); 
		query.append(", (SELECT NVL(XPT_ERR_MSG, XPT_ERR_DTL_MSG)" ).append("\n"); 
		query.append("FROM COM_FAX_SND_INFO" ).append("\n"); 
		query.append("WHERE FAX_SND_NO = FAX.SND_ID) AS FAX_FAIL_REASON" ).append("\n"); 
		query.append(", BK.BKG_NO" ).append("\n"); 
		query.append(", 'Fax' REMARK" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append(", (SELECT BKG_NO, SND_RQST_DT, SND_USR_ID, NTC_FAX_NO, SND_ID, BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND 'F'    = NTC_VIA_CD(+)" ).append("\n"); 
		query.append("AND DECODE(@[io_bnd_cd], 'O', 'HO', 'HI') = NTC_KND_CD) FAX" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.BKG_NO = FAX.BKG_NO (+)" ).append("\n"); 
		query.append("AND ROWNUM    = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT /*+ INDEX_DESC(FAX XPKBKG_NTC_HIS) INDEX_DESC(EML XPKBKG_NTC_HIS) */" ).append("\n"); 
		query.append("DECODE(@[io_bnd_cd], 'O', 'HO', 'HI') NTC_KND_CD" ).append("\n"); 
		query.append(", EML.NTC_EML EML" ).append("\n"); 
		query.append(", EML.SND_USR_ID EML_SENDER" ).append("\n"); 
		query.append(", (SELECT USR_NM FROM COM_USER USR WHERE USR.USR_ID = EML.SND_USR_ID) EML_SENDER_NM" ).append("\n"); 
		query.append(", NVL ((SELECT EML_DT" ).append("\n"); 
		query.append("FROM COM_EML_SND_INFO" ).append("\n"); 
		query.append("WHERE EML_SND_NO = EML.SND_ID),EML.SND_RQST_DT) AS EML_SEND_DT" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE 'CD02396' = INTG_CD_ID" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT =" ).append("\n"); 
		query.append("NVL2((SELECT EML_PROC_STS_CD" ).append("\n"); 
		query.append("FROM COM_EML_SND_INFO" ).append("\n"); 
		query.append("WHERE EML_SND_NO = EML.SND_ID)," ).append("\n"); 
		query.append("DECODE((SELECT EML_PROC_STS_CD" ).append("\n"); 
		query.append("FROM COM_EML_SND_INFO" ).append("\n"); 
		query.append("WHERE EML_SND_NO = EML.SND_ID),1,2,2,2,3,3,4,4,1)," ).append("\n"); 
		query.append("NVL2(EML.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("DECODE(EML.BKG_NTC_SND_RSLT_CD,3,3,4,4,1),1)) ) AS EML_SEND_RESULT" ).append("\n"); 
		query.append(", (SELECT EML_ERR_MSG" ).append("\n"); 
		query.append("FROM COM_EML_SND_INFO" ).append("\n"); 
		query.append("WHERE EML_SND_NO = EML.SND_ID) AS EML_FAIL_REASON" ).append("\n"); 
		query.append(", BK.BKG_NO" ).append("\n"); 
		query.append(", 'Email' REMARK" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append(", (SELECT BKG_NO, SND_RQST_DT, SND_USR_ID, NTC_EML, SND_ID, BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND 'M'    = NTC_VIA_CD(+)" ).append("\n"); 
		query.append("AND DECODE(@[io_bnd_cd], 'O', 'HO', 'HI') = NTC_KND_CD) EML" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.BKG_NO = EML.BKG_NO (+)" ).append("\n"); 
		query.append("AND ROWNUM    = 1" ).append("\n"); 

	}
}