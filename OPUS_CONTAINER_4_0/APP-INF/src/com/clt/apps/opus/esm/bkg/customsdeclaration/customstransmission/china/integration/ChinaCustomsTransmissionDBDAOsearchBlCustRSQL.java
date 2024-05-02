/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchBlCustRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.10
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchBlCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ChinaBlCustListVO
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchBlCustRSQL(){
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
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n");
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchBlCustRSQL").append("\n");
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
		query.append("SELECT  CST1.BL_NO" ).append("\n");
		query.append(",CST.BKG_CUST_TP_CD" ).append("\n");
		query.append(",CST.CNT_CD" ).append("\n");
		query.append(",CST.CUST_SEQ" ).append("\n");
		query.append(",CST.CUST_NM" ).append("\n");
		query.append(",CST.CUST_ADDR" ).append("\n");
		query.append(",CST1.CNT_CD AS SHPR_CNT_CD" ).append("\n");
		query.append(",CST1.CUST_SEQ AS SHPR_SEQ" ).append("\n");
		query.append(",CST1.CUST_NM AS SHPR_NM" ).append("\n");
		query.append(",CST1.CUST_ADDR AS SHPR_ADDR" ).append("\n");
		query.append(",CST1.CNT_CD AS CNEE_CNT_CD" ).append("\n");
		query.append(",CST1.CUST_SEQ AS CNEE_SEQ" ).append("\n");
		query.append(",CST2.CUST_NM AS CNEE_NM" ).append("\n");
		query.append(",CST2.CUST_ADDR AS CNEE_ADDR" ).append("\n");
		query.append(",CST1.CNT_CD AS NTFY_CNT_CD" ).append("\n");
		query.append(",CST1.CUST_SEQ AS NTFY_SEQ" ).append("\n");
		query.append(",CST3.CUST_NM AS NTFY_NM" ).append("\n");
		query.append(",CST3.CUST_ADDR AS NTFY_ADDR" ).append("\n");
		query.append("FROM    BKG_CSTMS_CHN_CUST CST1" ).append("\n");
		query.append(",BKG_CSTMS_CHN_CUST CST2" ).append("\n");
		query.append(",BKG_CSTMS_CHN_CUST CST3" ).append("\n");
		query.append(",BKG_CSTMS_CHN_CUST CST" ).append("\n");
		query.append("WHERE   1=1" ).append("\n");
		query.append("AND     CST.BL_NO               = @[bl_no]" ).append("\n");
		query.append("AND     CST.CHN_MF_SND_IND_CD   = @[trans_mode]" ).append("\n");
		query.append("AND     CST.BL_NO               = CST1.BL_NO" ).append("\n");
		query.append("AND     CST.CHN_MF_SND_IND_CD   = CST1.CHN_MF_SND_IND_CD" ).append("\n");
		query.append("AND     CST1.BKG_CUST_TP_CD     = 'S'" ).append("\n");
		query.append("AND     CST1.BL_NO              = CST2.BL_NO" ).append("\n");
		query.append("AND     CST1.CHN_MF_SND_IND_CD  = CST2.CHN_MF_SND_IND_CD" ).append("\n");
		query.append("AND     CST2.BKG_CUST_TP_CD     = 'C'" ).append("\n");
		query.append("AND     CST1.BL_NO              = CST3.BL_NO" ).append("\n");
		query.append("AND     CST1.CHN_MF_SND_IND_CD  = CST3.CHN_MF_SND_IND_CD" ).append("\n");
		query.append("AND     CST3.BKG_CUST_TP_CD     = 'N'" ).append("\n");

	}
}