/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOsearchUsWhfBlCntrListUSOAKRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.15 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsWharfageDecMgtDBDAOsearchUsWhfBlCntrListUSOAKRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUsWhfBlCntrListUSOAK
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOsearchUsWhfBlCntrListUSOAKRSQL(){
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
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration").append("\n"); 
		query.append("FileName : UsWharfageDecMgtDBDAOsearchUsWhfBlCntrListUSOAKRSQL").append("\n"); 
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
		query.append("WITH BKG_INFO AS (" ).append("\n"); 
		query.append("SELECT  B.BL_NO" ).append("\n"); 
		query.append("       ,C.CNTR_NO" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("         SELECT B.BL_NO, B.BKG_NO" ).append("\n"); 
		query.append("           FROM BKG_BOOKING B" ).append("\n"); 
		query.append("          WHERE B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("            AND B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("        ) B" ).append("\n"); 
		query.append("       ,BKG_CONTAINER C" ).append("\n"); 
		query.append(" WHERE  B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("SELECT  B.BL_NO" ).append("\n"); 
		query.append("       ,C.CNTR_NO" ).append("\n"); 
		query.append("  FROM  BKG_USA_WHF_BL B" ).append("\n"); 
		query.append("       ,BKG_USA_WHF_CNTR C" ).append("\n"); 
		query.append(" WHERE  B.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("   AND  B.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND  B.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND  B.PORT_CD = C.PORT_CD" ).append("\n"); 
		query.append("   AND  B.IO_BND_CD = C.IO_BND_CD" ).append("\n"); 
		query.append("   AND  B.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("   AND  B.VSL_CD = SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("   AND  B.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("   AND  B.SKD_DIR_CD = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("   AND  B.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("   AND  B.PORT_CD = @[port]" ).append("\n"); 
		query.append("   AND  B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    TB.BL_NO" ).append("\n"); 
		query.append(",   TB.CNTR_NO" ).append("\n"); 
		query.append(",   TB.FULL_MTY_CD" ).append("\n"); 
		query.append(",   TB.CSTMS_DESC" ).append("\n"); 
		query.append(",   TB.USA_WHF_EXPT_FLG" ).append("\n"); 
		query.append(",   TB.ORG_DEST_LOC_CD" ).append("\n"); 
		query.append(",   TB.USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append(",   DECODE(@[bound], 'I', TB.DE_TERM_CD, TB.RCV_TERM_CD) AS TERM" ).append("\n"); 
		query.append(",   DECODE(TB.USA_WHF_RAT_UT_CD, '20F', TB.CNTR_VOL_QTY) FT20" ).append("\n"); 
		query.append(",   DECODE(TB.USA_WHF_RAT_UT_CD, '40F', TB.CNTR_VOL_QTY) FT40" ).append("\n"); 
		query.append(",   DECODE(TB.USA_WHF_RAT_UT_CD, '45F', TB.CNTR_VOL_QTY) FT45" ).append("\n"); 
		query.append(",   TB.VSL_CD" ).append("\n"); 
		query.append(",   TB.SKD_VOY_NO" ).append("\n"); 
		query.append(",   TB.SKD_DIR_CD" ).append("\n"); 
		query.append(",   TB.PORT_CD" ).append("\n"); 
		query.append(",   TB.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",   TB.USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append(",   TB.CNTR_VOL_QTY" ).append("\n"); 
		query.append(",   TB.RCV_TERM_CD" ).append("\n"); 
		query.append(",   TB.DE_TERM_CD" ).append("\n"); 
		query.append(",   RT.WHF_UT_PRC" ).append("\n"); 
		query.append(",   TB.RAT_AS_QTY" ).append("\n"); 
		query.append(",   TB.STE_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT A.BL_NO" ).append("\n"); 
		query.append("          ,D.CNTR_NO" ).append("\n"); 
		query.append("          ,CASE WHEN A.BKG_CGO_TP_CD = 'F' THEN 'F'" ).append("\n"); 
		query.append("                WHEN A.BKG_CGO_TP_CD IN ('P','R') THEN 'M'" ).append("\n"); 
		query.append("                ELSE '' " ).append("\n"); 
		query.append("                END FULL_MTY_CD" ).append("\n"); 
		query.append("          ,C.CSTMS_DESC" ).append("\n"); 
		query.append("          ,'N' AS USA_WHF_EXPT_FLG" ).append("\n"); 
		query.append("          ,DECODE(@[bound], 'I', A.DEL_CD, A.POR_CD) AS ORG_DEST_LOC_CD" ).append("\n"); 
		query.append("          ,BKG_GET_USOAK_WHF_TRSP_TP_FNC(A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.BL_NO, @[bound]) AS USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("          ,D.RCV_TERM_CD" ).append("\n"); 
		query.append("          ,D.DE_TERM_CD" ).append("\n"); 
		query.append("          ,A.VSL_CD" ).append("\n"); 
		query.append("          ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("          ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("          ,DECODE(@[bound], 'I', A.POD_CD, A.POL_CD) AS PORT_CD" ).append("\n"); 
		query.append("          ,D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          ,CASE SUBSTR(D.CNTR_TPSZ_CD, 2, 1)" ).append("\n"); 
		query.append("           WHEN '2' THEN '20F'" ).append("\n"); 
		query.append("           WHEN '4' THEN '40F'" ).append("\n"); 
		query.append("           WHEN '5' THEN '40F'" ).append("\n"); 
		query.append("           ELSE '45F'" ).append("\n"); 
		query.append("            END AS USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append("          ,D.CNTR_VOL_QTY" ).append("\n"); 
		query.append("          ,D.CNTR_VOL_QTY AS RAT_AS_QTY" ).append("\n"); 
		query.append("          ,M.STE_CD" ).append("\n"); 
		query.append("      FROM BKG_BOOKING A" ).append("\n"); 
		query.append("          ,BKG_CUSTOMER B" ).append("\n"); 
		query.append("          ,BKG_BL_DOC C" ).append("\n"); 
		query.append("          ,BKG_CONTAINER D" ).append("\n"); 
		query.append("          ,BKG_INFO BKG" ).append("\n"); 
		query.append("          ,MDM_LOCATION M" ).append("\n"); 
		query.append("     WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("       AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("       AND B.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("       AND A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("       AND A.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("       AND D.CNTR_NO = BKG.CNTR_NO" ).append("\n"); 
		query.append("#if (${bound} == 'I')" ).append("\n"); 
		query.append("       AND A.DEL_CD = M.LOC_CD(+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND A.POR_CD = M.LOC_CD(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ) TB" ).append("\n"); 
		query.append("    ," ).append("\n"); 
		query.append("   (" ).append("\n"); 
		query.append("     SELECT USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append("           ,FULL_MTY_CD" ).append("\n"); 
		query.append("           ,USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("           ,USA_WHF_EXPT_FLG" ).append("\n"); 
		query.append("           ,WHF_UT_PRC" ).append("\n"); 
		query.append("       FROM BKG_USA_WHF_RT_DTL DTL" ).append("\n"); 
		query.append("           ,(SELECT MAX(EFF_DT) AS EFF_DT" ).append("\n"); 
		query.append("               FROM BKG_USA_WHF_RT" ).append("\n"); 
		query.append("              WHERE PORT_CD = @[port]" ).append("\n"); 
		query.append("                AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("            ) MAX_RT" ).append("\n"); 
		query.append("      WHERE PORT_CD = @[port]" ).append("\n"); 
		query.append("        AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("        AND DTL.EFF_DT = MAX_RT.EFF_DT" ).append("\n"); 
		query.append("       ) RT" ).append("\n"); 
		query.append(" WHERE  TB.USA_WHF_RAT_UT_CD = RT.USA_WHF_RAT_UT_CD(+)" ).append("\n"); 
		query.append("   AND  TB.FULL_MTY_CD = RT.FULL_MTY_CD(+)" ).append("\n"); 
		query.append("   AND  TB.USA_WHF_TRSP_TP_CD = RT.USA_WHF_TRSP_TP_CD(+)" ).append("\n"); 
		query.append("   AND  TB.USA_WHF_EXPT_FLG = RT.USA_WHF_EXPT_FLG(+)" ).append("\n"); 

	}
}