/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchUsaLocInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.25 김도완
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchUsaLocInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DWKIM, 0370, OUTVO: MxUsaLocVO
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchUsaLocInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mex.integration").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchUsaLocInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DECODE(IB.LOCL_CLR_IPI_MVMT_FLG, 'Y', 'Y', IB.CSTMS_CLR_TP_CD) local_ipi" ).append("\n"); 
		query.append(",NVL(L.LOC_CD, '     ') loc_cd" ).append("\n"); 
		query.append(",DECODE(LENGTH(RTRIM(L.LOC_AMS_PORT_CD)), 4, 'D', 5, 'K', 'N') dkn" ).append("\n"); 
		query.append(",RPAD(RTRIM(L.LOC_AMS_PORT_CD), 5) loc_ams_port_cd" ).append("\n"); 
		query.append(",L.LOC_NM loc_nm" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_BL BL, BKG_CSTMS_ADV_IBD IB" ).append("\n"); 
		query.append(",MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BL.CNT_CD = 'US'" ).append("\n"); 
		query.append("AND	BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND BL.CNT_CD = IB.CNT_CD" ).append("\n"); 
		query.append("AND BL.BL_NO = IB.BL_NO" ).append("\n"); 
		query.append("AND BL.HUB_LOC_CD = L.LOC_CD(+)" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}