/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchBlCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.31
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchBlCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChinaBlCntrListVO
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchBlCntrRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchBlCntrRSQL").append("\n"); 
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
		query.append("SELECT  CNT.BL_NO" ).append("\n"); 
		query.append(",CNT.CHN_MF_SND_IND_CD" ).append("\n"); 
		query.append(",CNT.CNTR_NO" ).append("\n"); 
		query.append(",CNT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",CNT.FULL_MTY_CD" ).append("\n"); 
		query.append(",SEL.SEAL_NO" ).append("\n"); 
		query.append(",SEL.SEAL_KND_CD" ).append("\n"); 
		query.append(",SEL.SEAL_PTY_TP_CD" ).append("\n"); 
		query.append(",SEL.SEAL_PTY_NM" ).append("\n"); 
		query.append(",CNT.PCK_QTY" ).append("\n"); 
		query.append(",CNT.PCK_TP_CD" ).append("\n"); 
		query.append(",CNT.CNTR_WGT" ).append("\n"); 
		query.append(",CNT.WGT_UT_CD" ).append("\n"); 
		query.append(",CNT.CNTR_MEAS_QTY" ).append("\n"); 
		query.append(",CNT.MEAS_UT_CD" ).append("\n"); 
		query.append(",AWK.OVR_DIM_FNT_LEN" ).append("\n"); 
		query.append(",AWK.OVR_DIM_REAR_LEN" ).append("\n"); 
		query.append(",AWK.OVR_HGT" ).append("\n"); 
		query.append(",AWK.OVR_DIM_LF_LEN" ).append("\n"); 
		query.append(",AWK.OVR_DIM_RT_LEN" ).append("\n"); 
		query.append("FROM    (SELECT  BL.BL_NO" ).append("\n"); 
		query.append(",BL.BKG_NO" ).append("\n"); 
		query.append(",BL.CHN_MF_SND_IND_CD" ).append("\n"); 
		query.append(",CT.CNTR_NO" ).append("\n"); 
		query.append(",CT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",CT.FULL_MTY_CD" ).append("\n"); 
		query.append(",CT.PCK_QTY" ).append("\n"); 
		query.append(",CT.PCK_TP_CD" ).append("\n"); 
		query.append(",DECODE(CT.CNTR_WGT, 0 ,'', CT.CNTR_WGT) AS CNTR_WGT" ).append("\n"); 
		query.append(",CT.WGT_UT_CD" ).append("\n"); 
		query.append(",DECODE(CT.CNTR_MEAS_QTY, 0 ,'', CT.CNTR_MEAS_QTY) AS CNTR_MEAS_QTY" ).append("\n"); 
		query.append(",CT.MEAS_UT_CD" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_CHN_BL   BL" ).append("\n"); 
		query.append(",BKG_CSTMS_CHN_CNTR CT" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     CT.BL_NO               =    @[bl_no]" ).append("\n"); 
		query.append("AND     CT.CHN_MF_SND_IND_CD   =    @[trans_mode]" ).append("\n"); 
		query.append("AND     CT.BL_NO               =    BL.BL_NO" ).append("\n"); 
		query.append("AND     CT.CHN_MF_SND_IND_CD   =    BL.CHN_MF_SND_IND_CD" ).append("\n"); 
		query.append(") CNT" ).append("\n"); 
		query.append(",BKG_CSTMS_SEAL_NO SEL" ).append("\n"); 
		query.append(",BKG_CSTMS_CHN_AWK AWK" ).append("\n"); 
		query.append("WHERE   CNT.BL_NO               =    @[bl_no]" ).append("\n"); 
		query.append("AND     CNT.CHN_MF_SND_IND_CD   =    @[trans_mode]" ).append("\n"); 
		query.append("AND     CNT.BL_NO               =    SEL.BL_NO(+)" ).append("\n"); 
		query.append("AND     CNT.CNTR_NO             =    SEL.CNTR_NO(+)" ).append("\n"); 
		query.append("AND     SEL.CNT_CD(+)           =    'CN'" ).append("\n"); 
		query.append("AND     SEL.CSTMS_DIV_ID(+)     =    'CTM'" ).append("\n"); 
		query.append("AND     SEL.SEAL_NO_SEQ(+)      =    1" ).append("\n"); 
		query.append("AND     CNT.BL_NO               =    AWK.BL_NO(+)" ).append("\n"); 
		query.append("AND     CNT.CNTR_NO             =    AWK.CNTR_NO(+)" ).append("\n"); 
		query.append("AND     CNT.CHN_MF_SND_IND_CD   =    AWK.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("GROUP BY CNT.BL_NO" ).append("\n"); 
		query.append(",CNT.CHN_MF_SND_IND_CD" ).append("\n"); 
		query.append(",CNT.CNTR_NO" ).append("\n"); 
		query.append(",CNT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",CNT.FULL_MTY_CD" ).append("\n"); 
		query.append(",SEL.SEAL_NO" ).append("\n"); 
		query.append(",SEL.SEAL_KND_CD" ).append("\n"); 
		query.append(",SEL.SEAL_PTY_TP_CD" ).append("\n"); 
		query.append(",SEL.SEAL_PTY_NM" ).append("\n"); 
		query.append(",CNT.PCK_QTY" ).append("\n"); 
		query.append(",CNT.PCK_TP_CD" ).append("\n"); 
		query.append(",CNT.CNTR_WGT" ).append("\n"); 
		query.append(",CNT.WGT_UT_CD" ).append("\n"); 
		query.append(",CNT.CNTR_MEAS_QTY" ).append("\n"); 
		query.append(",CNT.MEAS_UT_CD" ).append("\n"); 
		query.append(",AWK.OVR_DIM_FNT_LEN" ).append("\n"); 
		query.append(",AWK.OVR_DIM_REAR_LEN" ).append("\n"); 
		query.append(",AWK.OVR_HGT" ).append("\n"); 
		query.append(",AWK.OVR_DIM_LF_LEN" ).append("\n"); 
		query.append(",AWK.OVR_DIM_RT_LEN" ).append("\n"); 
		query.append("ORDER BY CNT.CNTR_NO" ).append("\n"); 

	}
}