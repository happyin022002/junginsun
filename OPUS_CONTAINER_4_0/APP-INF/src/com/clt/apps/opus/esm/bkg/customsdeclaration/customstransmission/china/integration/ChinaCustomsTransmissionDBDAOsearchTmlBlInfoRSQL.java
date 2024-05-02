/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchTmlBlInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.03
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.08.03 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchTmlBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * TmlBlVO
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchTmlBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n");
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchTmlBlInfoRSQL").append("\n");
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
		query.append("SELECT  BKG.BL_NO    BL_NO" ).append("\n");
		query.append(",BKG.BKG_NO   BKG_NO" ).append("\n");
		query.append(",BKG.POL_CD   BL_POL" ).append("\n");
		query.append(",POL.LOC_NM   BL_POL_NAME" ).append("\n");
		query.append(",BKG.POD_CD   BL_POD" ).append("\n");
		query.append(",POD.LOC_NM   BL_POD_NAME" ).append("\n");
		query.append(",BKG.DEL_CD   BL_DEL" ).append("\n");
		query.append(",DEL.LOC_NM   BL_DEL_NAME" ).append("\n");
		query.append(",SUBSTR(REPLACE(REPLACE(SHPR.CUST_NM, CHR(10), ''), CHR(13), ' '),1,100) SHPR" ).append("\n");
		query.append(",SUBSTR(REPLACE(REPLACE(CNEE.CUST_NM, CHR(10), ''), CHR(13), ' '),1,100) CNEE" ).append("\n");
		query.append(",SUBSTR(REPLACE(REPLACE(NTFY.CUST_NM, CHR(10), ''), CHR(13), ' '),1,100) NTFY" ).append("\n");
		query.append(",NVL(NVL((SELECT CSTMS_DESC FROM BKG_BL_DOC WHERE BKG_NO = BKG.BKG_NO),CMDT.CMDT_NM), RCMDT.REP_CMDT_NM) CGO_DESC" ).append("\n");
		query.append("FROM    BKG_BOOKING BKG," ).append("\n");
		query.append("MDM_LOCATION POL," ).append("\n");
		query.append("MDM_LOCATION POD," ).append("\n");
		query.append("MDM_LOCATION DEL," ).append("\n");
		query.append("BKG_CUSTOMER SHPR," ).append("\n");
		query.append("BKG_CUSTOMER CNEE," ).append("\n");
		query.append("BKG_CUSTOMER NTFY," ).append("\n");
		query.append("MDM_COMMODITY CMDT," ).append("\n");
		query.append("MDM_REP_CMDT RCMDT" ).append("\n");
		query.append("WHERE 1=1" ).append("\n");
		query.append("AND BKG.POL_CD = POL.LOC_CD(+)" ).append("\n");
		query.append("AND BKG.POD_CD = POD.LOC_CD(+)" ).append("\n");
		query.append("AND BKG.DEL_CD = DEL.LOC_CD(+)" ).append("\n");
		query.append("AND BKG.BKG_NO = SHPR.BKG_NO(+)" ).append("\n");
		query.append("AND SHPR.BKG_CUST_TP_CD(+) = 'S'" ).append("\n");
		query.append("AND BKG.BKG_NO = CNEE.BKG_NO(+)" ).append("\n");
		query.append("AND CNEE.BKG_CUST_TP_CD(+) = 'C'" ).append("\n");
		query.append("AND BKG.BKG_NO = NTFY.BKG_NO(+)" ).append("\n");
		query.append("AND NTFY.BKG_CUST_TP_CD(+) = 'N'" ).append("\n");
		query.append("AND BKG.cmdt_cd = CMDT.cmdt_cd(+)" ).append("\n");
		query.append("AND BKG.REP_CMDT_CD = RCMDT.REP_CMDT_CD(+)" ).append("\n");
		query.append("AND BKG.BKG_STS_CD <> 'X'" ).append("\n");
		query.append("AND ( #foreach($field_id in ${field_list})" ).append("\n");
		query.append("#if($velocityCount > 1)" ).append("\n");
		query.append("OR #end      BKG.BKG_NO IN ( $field_id )" ).append("\n");
		query.append("#end" ).append("\n");
		query.append(")" ).append("\n");

	}
}