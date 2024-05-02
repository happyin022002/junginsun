/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchOFMBlLineInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.12.03 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchOFMBlLineInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim OFM 생성을 위한 BL 정보 쿼리.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchOFMBlLineInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchOFMBlLineInfoRSQL").append("\n"); 
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
		query.append("'BL_INFO{'||CHR(10)||" ).append("\n"); 
		query.append("'BLNBR | '||NVL(IT.BL_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("'BKGNBR | '     ||NVL(IT.BKG_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("'DEL_LOC | '    ||NVL(LOC2.LOC_NM,' ')||CHR(10)||" ).append("\n"); 
		query.append("'PKG_QTY | '||NVL(IT.PCK_QTY,0)||CHR(10)||" ).append("\n"); 
		query.append("'PKG_UNIT | '||NVL(IT.AMS_PCK_TP_CD,'PKGS')||CHR(10)||" ).append("\n"); 
		query.append("'WGT_QTY | '||NVL(IT.CGO_WGT,0)||CHR(10)||" ).append("\n"); 
		query.append("'WGT_UNIT | '||NVL(IT.WGT_UT_CD,'KG')||CHR(10)||" ).append("\n"); 
		query.append("'MEA_QTY | '||NVL(IT.MEAS_QTY,0)||CHR(10)||" ).append("\n"); 
		query.append("'MEA_UNIT | '||NVL(IT.MEAS_UT_CD,'CM')||CHR(10)||" ).append("\n"); 
		query.append("'POR_LOC | '||NVL(LOC.LOC_NM,' ')||CHR(10) BUF1," ).append("\n"); 
		query.append("NVL(IBD.IBD_TRSP_NO,' ') IT_ITNO," ).append("\n"); 
		query.append("NVL(IBD.IBD_TRSP_TP_CD,'  ') IT_ITTYPE," ).append("\n"); 
		query.append("NVL(IT.HUB_LOC_CD,' ') IT_HUB," ).append("\n"); 
		query.append("NVL(IT.USA_LST_LOC_CD,' ') IT_LST_USA," ).append("\n"); 
		query.append("NVL(IT.DEL_CD,' ') IT_DEL," ).append("\n"); 
		query.append("IT.CGO_WGT*20 WGT_VAL," ).append("\n"); 
		query.append("NVL(IT.PCK_QTY,0) IT_PKG_QTY," ).append("\n"); 
		query.append("NVL(IT.AMS_PCK_TP_CD,'PKG  ') IT_PKG_AMS," ).append("\n"); 
		query.append("NVL(IBD.CSTMS_CLR_TP_CD,' ') IT_IPI_LOCAL" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_BL IT, MDM_LOCATION LOC, MDM_LOCATION LOC2, BKG_CSTMS_ADV_IBD IBD" ).append("\n"); 
		query.append("WHERE IT.CNT_CD = 'US'" ).append("\n"); 
		query.append("AND IT.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("AND IT.POR_CD     = LOC.LOC_CD" ).append("\n"); 
		query.append("AND IT.DEL_CD     = LOC2.LOC_CD(+)" ).append("\n"); 
		query.append("AND IT.BL_NO       = IBD.BL_NO" ).append("\n"); 
		query.append("AND IT.CNT_CD      = IBD.CNT_CD" ).append("\n"); 

	}
}