/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CIMCommonDBDAOModifyBkgContainerEtcDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOModifyBkgContainerEtcDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container 추가 수정
	  * </pre>
	  */
	public CIMCommonDBDAOModifyBkgContainerEtcDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOModifyBkgContainerEtcDataUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CONTAINER BC" ).append("\n"); 
		query.append("SET    BC.CNMV_YR          = NULL" ).append("\n"); 
		query.append("      ,  BC.CNMV_ID_NO     = NULL" ).append("\n"); 
		query.append("      ,  BC.CNMV_CYC_NO    = 9999" ).append("\n"); 
		query.append("      ,  BC.CNMV_STS_CD    = NULL" ).append("\n"); 
		query.append("      ,  BC.CNMV_EVNT_DT   = NULL" ).append("\n"); 
		query.append("      ,  BC.ORG_YD_CD	   = NULL" ).append("\n"); 
		query.append("      ,  BC.DIFF_RMK       = NULL" ).append("\n"); 
		query.append("      ,  BC.CGO_RCV_DT     = NULL" ).append("\n"); 
		query.append("      ,  BC.CGO_RCV_YD_CD  = NULL" ).append("\n"); 
		query.append("WHERE BC.CRE_DT > TO_DATE('2015-08-01', 'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND   NVL(BC.CNMV_CYC_NO, 0) != 9999" ).append("\n"); 
		query.append("AND   BC.CNTR_NO = @[cntr_no]                      " ).append("\n"); 
		query.append("AND  (BC.CNTR_NO, BC.BKG_NO)  IN  ( SELECT SBC.CNTR_NO" ).append("\n"); 
		query.append("                                         , SUBSTR (MAX(TO_CHAR (NVL (VPS.VPS_ETD_DT, SBB.CRE_DT), 'YYYYMMDDHH24MISS') || SBC.BKG_NO),15)" ).append("\n"); 
		query.append("                                      FROM BKG_CONTAINER SBC, BKG_BOOKING SBB, BKG_VVD BV, VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                                      WHERE SBB.BKG_NO                 = SBC.BKG_NO" ).append("\n"); 
		query.append("                                      AND   SBC.CNTR_NO                = @[cntr_no]" ).append("\n"); 
		query.append("                                      AND   NVL(SBB.BKG_STS_CD, 'X')  != 'X'" ).append("\n"); 
		query.append("                                      AND   SBB.BKG_NO                 = BV.BKG_NO(+)" ).append("\n"); 
		query.append("                                      AND   BV.VSL_PRE_PST_CD(+)       = 'T'" ).append("\n"); 
		query.append("                                      AND   BV.VSL_CD                  = VPS.VSL_CD(+)" ).append("\n"); 
		query.append("                                      AND   BV.SKD_VOY_NO              = VPS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                                      AND   BV.SKD_DIR_CD              = VPS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                                      AND   BV.POL_CD                  = SUBSTR (VPS.YD_CD(+), 1, 5)                                   " ).append("\n"); 
		query.append("                                      GROUP BY SBC.CNTR_NO)" ).append("\n"); 
		query.append("AND   NOT EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                    FROM  CTM_MOVEMENT  CM" ).append("\n"); 
		query.append("                   WHERE  BC.BKG_NO  = CM.BKG_NO" ).append("\n"); 
		query.append("                     AND  BC.CNTR_NO = CM.CNTR_NO)" ).append("\n"); 

	}
}