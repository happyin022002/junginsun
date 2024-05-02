/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchOFMCntrLineRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.07.07 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchOFMCntrLineRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim OFM Cntr line info 쿼리.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchOFMCntrLineRSQL(){
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
		query.append("'CNTR_INFO{'||CHR(10)||" ).append("\n"); 
		query.append("'CNTRNBR | '||C.CNTR_NO||CHR(10)||" ).append("\n"); 
		query.append("'SEALNBR | '||S.SEAL_NO1||CHR(10)||" ).append("\n"); 
		query.append("'CNTR_TYPE | '||C.CNTR_TPSZ_CD||CHR(10)||" ).append("\n"); 
		query.append("'SERVICE_TYPE | '||NVL(B.RCV_TERM_CD,' ')||NVL(B.DE_TERM_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("'PKG_COUNT | '||C.PCK_QTY||CHR(10) buf3," ).append("\n"); 
		query.append("C.CNTR_NO" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_BL B, BKG_CSTMS_ADV_CNTR C," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.CNT_CD, A.BL_NO," ).append("\n"); 
		query.append("MAX(DECODE(A.LVL, 1, SEAL_NO)) SEAL_NO1," ).append("\n"); 
		query.append("MAX(DECODE(A.LVL, 2, SEAL_NO)) SEAL_NO2" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT ROWNUM LVL, A.CNT_CD, A.BL_NO, S.SEAL_NO" ).append("\n"); 
		query.append("FROM BKG_CSTMS_SEAL_NO S, BKG_CSTMS_ADV_BL A" ).append("\n"); 
		query.append("WHERE A.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("AND A.BL_NO = S.BL_NO" ).append("\n"); 
		query.append("AND A.CNT_CD = S.CNT_CD" ).append("\n"); 
		query.append("AND S.CSTMS_DIV_ID(+)= 'CTM'" ).append("\n"); 
		query.append("ORDER BY SEAL_NO" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("GROUP BY A.CNT_CD, A.BL_NO" ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append("WHERE B.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("AND B.CNT_CD     = C.CNT_CD" ).append("\n"); 
		query.append("AND B.BL_NO      = C.BL_NO" ).append("\n"); 
		query.append("AND C.IBD_CNTR_STS_CD  = 'A'" ).append("\n"); 
		query.append("AND B.CNT_CD         = S.CNT_CD(+)" ).append("\n"); 
		query.append("AND B.BL_NO          = S.BL_NO(+)" ).append("\n"); 
		query.append("AND B.CNT_CD = 'US'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.customstransmission.usa.integration ").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchOFMCntrLineRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}