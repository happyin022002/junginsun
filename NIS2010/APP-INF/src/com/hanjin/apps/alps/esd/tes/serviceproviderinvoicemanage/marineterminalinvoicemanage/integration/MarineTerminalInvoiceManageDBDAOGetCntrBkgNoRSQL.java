/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOGetCntrBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOGetCntrBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 검색조건: I/O + Yard code + 공통항차 Voyage의 Year-Month에 속한 컨테이너 VL/VD와 mapping된 Full_Bkg
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOGetCntrBkgNoRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOGetCntrBkgNoRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append("     , A.CNTR_NO" ).append("\n"); 
		query.append("     , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , DECODE(BR.CONTI_CD,BD.CONTI_CD,'I','O') IOC_CD" ).append("\n"); 
		query.append("     , CASE WHEN COUNT(FDR.FDR_POD_CD) > 0" ).append("\n"); 
		query.append("            THEN DECODE(@[io_bnd_cd],'I',DECODE(V.POD_CD,B.POD_CD,DECODE(V.POL_CD,B.POL_CD,'L','T'),'T')," ).append("\n"); 
		query.append("                'O',DECODE(V.POL_CD,B.POL_CD,DECODE(V.POD_CD,B.POD_CD,'L','T'),'T'))" ).append("\n"); 
		query.append("        ELSE 'L'" ).append("\n"); 
		query.append("        END LOCL_TS_IND_CD" ).append("\n"); 
		query.append("     , CASE WHEN COUNT(FDR.FDR_POD_CD) > 0" ).append("\n"); 
		query.append("            THEN DECODE(V.VSL_PRE_PST_CD,'T','V',NULL,'O','','O'," ).append("\n"); 
		query.append("                     DECODE(@[io_bnd_cd],'I'," ).append("\n"); 
		query.append("                         DECODE(V.POL_CD,F.FDR_POL_CD,'B','F')," ).append("\n"); 
		query.append("                           DECODE(V.POD_CD,F.FDR_POD_CD,'B','F')))" ).append("\n"); 
		query.append("        ELSE  'B'" ).append("\n"); 
		query.append("        END TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("     , V.SLAN_CD LANE_CD" ).append("\n"); 
		query.append("     , B.BL_NO" ).append("\n"); 
		query.append("     , B.RCV_TERM_CD||'/'||B.DE_TERM_CD RCVDE_TERM_IND_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT H.BKG_NO, H.CNTR_NO, H.CNTR_TPSZ_CD, D.ACT_DT, D.VSL_CD" ).append("\n"); 
		query.append("    FROM SCE_COP_HDR H, SCE_COP_DTL D" ).append("\n"); 
		query.append("    WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("    AND D.ACT_STS_MAPG_CD = DECODE(@[io_bnd_cd],'I','VD','VL')" ).append("\n"); 
		query.append("    AND D.NOD_CD = @[yd_cd] AND H.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("    AND (TO_CHAR(D.ACT_DT,'YYMM') = @[skd_voy_no] OR TO_CHAR(D.PLN_DT,'YYMM') = @[skd_voy_no])" ).append("\n"); 
		query.append("    ) A, BKG_VVD V, BKG_BOOKING B, MDM_LOCATION BR, MDM_LOCATION BD, TES_TML_SPCL_FDR F, TES_TML_SPCL_FDR FDR" ).append("\n"); 
		query.append("WHERE A.BKG_NO = V.BKG_NO " ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("AND B.POR_CD = BR.LOC_CD(+)" ).append("\n"); 
		query.append("AND B.POD_CD = BD.LOC_CD(+)" ).append("\n"); 
		query.append("AND V.POD_CD = F.FDR_POD_CD(+)" ).append("\n"); 
		query.append("AND V.POL_CD = F.FDR_POL_CD(+)" ).append("\n"); 
		query.append("AND DECODE(@[io_bnd_cd],'I',V.POD_CD,V.POL_CD) = DECODE(@[io_bnd_cd], 'I',FDR.FDR_POD_CD(+), FDR.FDR_POL_CD(+))" ).append("\n"); 
		query.append("GROUP BY A.BKG_NO" ).append("\n"); 
		query.append("     , A.CNTR_NO" ).append("\n"); 
		query.append("     , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , BR.CONTI_CD, BD.CONTI_CD" ).append("\n"); 
		query.append("     , V.POD_CD, B.POD_CD, V.POL_CD, B.POL_CD" ).append("\n"); 
		query.append("     , V.VSL_PRE_PST_CD, F.FDR_POL_CD, F.FDR_POD_CD" ).append("\n"); 
		query.append("     , V.SLAN_CD" ).append("\n"); 
		query.append("     , B.BL_NO" ).append("\n"); 
		query.append("     , B.RCV_TERM_CD, B.DE_TERM_CD" ).append("\n"); 

	}
}