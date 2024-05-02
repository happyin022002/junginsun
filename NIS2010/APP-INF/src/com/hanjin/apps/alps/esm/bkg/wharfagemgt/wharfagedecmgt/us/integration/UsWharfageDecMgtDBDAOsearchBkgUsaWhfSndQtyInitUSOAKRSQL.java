/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOsearchBkgUsaWhfSndQtyInitUSOAKRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.14
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.07.14 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min-Jeong Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsWharfageDecMgtDBDAOsearchBkgUsaWhfSndQtyInitUSOAKRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgUsaWhfSndQtyInitUSOAK
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOsearchBkgUsaWhfSndQtyInitUSOAKRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration").append("\n"); 
		query.append("FileName : UsWharfageDecMgtDBDAOsearchBkgUsaWhfSndQtyInitUSOAKRSQL").append("\n"); 
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
		query.append("WITH RT_DTL AS (" ).append("\n"); 
		query.append("SELECT USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append("      ,FULL_MTY_CD" ).append("\n"); 
		query.append("      ,USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("      ,USA_WHF_EXPT_FLG" ).append("\n"); 
		query.append("      ,WHF_UT_PRC" ).append("\n"); 
		query.append("  FROM BKG_USA_WHF_RT_DTL DTL" ).append("\n"); 
		query.append("      ,(SELECT MAX(EFF_DT) AS EFF_DT" ).append("\n"); 
		query.append("          FROM BKG_USA_WHF_RT_DTL" ).append("\n"); 
		query.append("         WHERE PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("           AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("       ) MAX_RT" ).append("\n"); 
		query.append(" WHERE PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND DTL.EFF_DT = MAX_RT.EFF_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[vsl_cd]     AS VSL_CD" ).append("\n"); 
		query.append("      ,@[skd_voy_no] AS SKD_VOY_NO" ).append("\n"); 
		query.append("      ,@[skd_dir_cd] AS SKD_DIR_CD" ).append("\n"); 
		query.append("      ,@[port_cd]    AS PORT_CD" ).append("\n"); 
		query.append("      ,@[io_bnd_cd]  AS IO_BND_CD" ).append("\n"); 
		query.append("      ,TB.USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append("      ,TB.FULL_MTY_CD" ).append("\n"); 
		query.append("      ,TB.USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("      ,'N' AS USA_WHF_EXPT_FLG" ).append("\n"); 
		query.append("      ,TB.RAT_AS_QTY" ).append("\n"); 
		query.append("      ,NVL(RT_DTL.WHF_UT_PRC, 0) AS WHF_UT_PRC" ).append("\n"); 
		query.append("      ,TB.RAT_AS_QTY * NVL(RT_DTL.WHF_UT_PRC, 0) AS WHF_AMT" ).append("\n"); 
		query.append("      ,@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT TB1.*" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("                SELECT TB.USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("                      ,TB.FULL_MTY_CD" ).append("\n"); 
		query.append("                      ,TB.USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append("                      ,0 AS RAT_AS_QTY" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT INT.*" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT 'L' AS USA_WHF_TRSP_TP_CD, 'F' AS FULL_MTY_CD, '20F' AS USA_WHF_RAT_UT_CD FROM DUAL" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT 'L', 'F', '40F' FROM DUAL" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT 'L', 'F', '45F' FROM DUAL" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT 'L', 'M', '20F' FROM DUAL" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT 'L', 'M', '40F' FROM DUAL" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT 'L', 'M', '45F' FROM DUAL" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT 'I', 'F', '20F' FROM DUAL" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT 'I', 'F', '40F' FROM DUAL" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT 'I', 'F', '45F' FROM DUAL" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT 'I', 'M', '20F' FROM DUAL" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT 'I', 'M', '40F' FROM DUAL" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT 'I', 'M', '45F' FROM DUAL" ).append("\n"); 
		query.append("                               )INT" ).append("\n"); 
		query.append("                                MINUS" ).append("\n"); 
		query.append("                                SELECT A.USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("                                      ,A.FULL_MTY_CD" ).append("\n"); 
		query.append("                                      ,A.USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append("                                  FROM BKG_USA_WHF_CNTR A" ).append("\n"); 
		query.append("                                 WHERE A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                   AND A.SKD_VOY_NO =@[skd_voy_no]" ).append("\n"); 
		query.append("                                   AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                   AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                                   AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                                GROUP BY A.USA_WHF_TRSP_TP_CD, A.FULL_MTY_CD,A.USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append("                        ) TB" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT A.USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("                      ,A.FULL_MTY_CD" ).append("\n"); 
		query.append("                      ,A.USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append("                      ,SUM(RAT_AS_QTY) AS RAT_AS_QTY" ).append("\n"); 
		query.append("                  FROM BKG_USA_WHF_CNTR A" ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO =@[skd_voy_no]" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                   AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                   AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                GROUP BY A.USA_WHF_TRSP_TP_CD, A.FULL_MTY_CD,A.USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append("               )TB1" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT TB1.*" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT 'L' AS USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("                      ,'F' AS FULL_MTY_CD" ).append("\n"); 
		query.append("                      ,'CON' AS USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append("                      ,NVL(SUM(RAT_AS_QTY),0) AS RAT_AS_QTY" ).append("\n"); 
		query.append("                  FROM BKG_USA_WHF_CNTR A" ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO =@[skd_voy_no]" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                   AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                   AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                   AND A.FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("                   AND A.USA_WHF_TRSP_TP_CD = 'L'" ).append("\n"); 
		query.append("               )TB1" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT TB1.*" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT 'L' AS USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("                      ,'F' AS FULL_MTY_CD" ).append("\n"); 
		query.append("                      ,'TEU' AS USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append("                      ,NVL(SUM(DECODE(A.USA_WHF_RAT_UT_CD, '40F', A.RAT_AS_QTY * 2, '45F', A.RAT_AS_QTY * 2.25, A.RAT_AS_QTY)),0) AS RAT_AS_QTY" ).append("\n"); 
		query.append("                  FROM BKG_USA_WHF_CNTR A" ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO =@[skd_voy_no]" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                   AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                   AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                   AND A.FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("                   AND A.USA_WHF_TRSP_TP_CD = 'L'" ).append("\n"); 
		query.append("               )TB1" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT TB1.*" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT 'I' AS USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("                      ,'F' AS FULL_MTY_CD" ).append("\n"); 
		query.append("                      ,'CON' AS USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append("                      ,NVL(SUM(RAT_AS_QTY),0) AS RAT_AS_QTY" ).append("\n"); 
		query.append("                  FROM BKG_USA_WHF_CNTR A" ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO =@[skd_voy_no]" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                   AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                   AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                   AND A.FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("                   AND A.USA_WHF_TRSP_TP_CD = 'I'" ).append("\n"); 
		query.append("               )TB1" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT TB1.*" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT 'I' AS USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("                      ,'F' AS FULL_MTY_CD" ).append("\n"); 
		query.append("                      ,'TEU' AS USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append("                      ,NVL(SUM(DECODE(A.USA_WHF_RAT_UT_CD, '40F', A.RAT_AS_QTY * 2, '45F', A.RAT_AS_QTY * 2.25, A.RAT_AS_QTY)),0) AS RAT_AS_QTY" ).append("\n"); 
		query.append("                  FROM BKG_USA_WHF_CNTR A" ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO =@[skd_voy_no]" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                   AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                   AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                   AND A.FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("                   AND A.USA_WHF_TRSP_TP_CD = 'I'" ).append("\n"); 
		query.append("               )TB1" ).append("\n"); 
		query.append("        )TB, RT_DTL" ).append("\n"); 
		query.append(" WHERE TB.USA_WHF_TRSP_TP_CD = RT_DTL.USA_WHF_TRSP_TP_CD(+)" ).append("\n"); 
		query.append("   AND TB.FULL_MTY_CD = RT_DTL.FULL_MTY_CD(+)" ).append("\n"); 
		query.append("   AND TB.USA_WHF_RAT_UT_CD = RT_DTL.USA_WHF_RAT_UT_CD(+)" ).append("\n"); 

	}
}