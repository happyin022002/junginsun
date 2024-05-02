/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOaddBkgUsaWhfCntrInitUSLGBCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsWharfageDecMgtDBDAOaddBkgUsaWhfCntrInitUSLGBCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgUsaWhfCntrInitUSLGB
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOaddBkgUsaWhfCntrInitUSLGBCSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration").append("\n"); 
		query.append("FileName : UsWharfageDecMgtDBDAOaddBkgUsaWhfCntrInitUSLGBCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_USA_WHF_CNTR (" ).append("\n"); 
		query.append("    VSL_CD" ).append("\n"); 
		query.append(",   SKD_VOY_NO" ).append("\n"); 
		query.append(",   SKD_DIR_CD" ).append("\n"); 
		query.append(",   PORT_CD" ).append("\n"); 
		query.append(",   IO_BND_CD" ).append("\n"); 
		query.append(",   BL_NO" ).append("\n"); 
		query.append(",   CNTR_NO" ).append("\n"); 
		query.append(",   CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",   FULL_MTY_CD" ).append("\n"); 
		query.append(",   CNTR_VOL_QTY" ).append("\n"); 
		query.append(",   RCV_TERM_CD" ).append("\n"); 
		query.append(",   DE_TERM_CD" ).append("\n"); 
		query.append(",   USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append(",   USA_WHF_EXPT_FLG" ).append("\n"); 
		query.append(",   USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append(",   RAT_AS_QTY" ).append("\n"); 
		query.append(",   WHF_UT_PRC" ).append("\n"); 
		query.append(",   CRE_USR_ID" ).append("\n"); 
		query.append(",   UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    TB.VSL_CD" ).append("\n"); 
		query.append(",   TB.SKD_VOY_NO" ).append("\n"); 
		query.append(",   TB.SKD_DIR_CD" ).append("\n"); 
		query.append(",   TB.PORT_CD" ).append("\n"); 
		query.append(",   TB.IO_BND_CD" ).append("\n"); 
		query.append(",   TB.BL_NO" ).append("\n"); 
		query.append(",   TB.CNTR_NO" ).append("\n"); 
		query.append(",   TB.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",   TB.FULL_MTY_CD" ).append("\n"); 
		query.append(",   DECODE(TB.FULL_MTY_CD,'M',1,TB.CNTR_VOL_QTY)" ).append("\n"); 
		query.append(",   TB.RCV_TERM_CD" ).append("\n"); 
		query.append(",   TB.DE_TERM_CD" ).append("\n"); 
		query.append(",   TB.USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append(",   TB.USA_WHF_EXPT_FLG" ).append("\n"); 
		query.append(",   TB.USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append(",   DECODE(TB.FULL_MTY_CD,'M',1,TB.CNTR_VOL_QTY)" ).append("\n"); 
		query.append(",   RT.WHF_UT_PRC" ).append("\n"); 
		query.append(",   @[cre_usr_id]" ).append("\n"); 
		query.append(",   @[cre_usr_id]" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  BKG.*" ).append("\n"); 
		query.append("               ,DECODE(BKG.KW_NM, NULL, 'N', 'Y') AS USA_WHF_EXPT_FLG" ).append("\n"); 
		query.append("               ,CNTR.CNTR_NO" ).append("\n"); 
		query.append("               ,CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("               ,CNTR.CNTR_VOL_QTY" ).append("\n"); 
		query.append("               ,CNTR.RCV_TERM_CD" ).append("\n"); 
		query.append("               ,CNTR.DE_TERM_CD" ).append("\n"); 
		query.append("               ,DECODE(BKG.USA_WHF_TRSP_TP_CD1, 'T', 'T', 'L', 'L', " ).append("\n"); 
		query.append("                       BKG_GET_USLGB_WHF_TRSP_TP_FNC(BKG.BKG_NO, CNTR.CNTR_NO, @[io_bnd_cd], @[port_cd])) AS USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("               ,CASE SUBSTR(CNTR.CNTR_TPSZ_CD, 2, 1)" ).append("\n"); 
		query.append("                    WHEN '2' THEN '20F'" ).append("\n"); 
		query.append("                    WHEN '4' THEN '40F'" ).append("\n"); 
		query.append("                    WHEN '5' THEN '40F'" ).append("\n"); 
		query.append("                    ELSE '45F'" ).append("\n"); 
		query.append("                 END AS USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                       A.VSL_CD" ).append("\n"); 
		query.append("                      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                      ,DECODE(@[io_bnd_cd], 'I', A.POD_CD, A.POL_CD) AS PORT_CD" ).append("\n"); 
		query.append("                      ,@[io_bnd_cd] AS IO_BND_CD" ).append("\n"); 
		query.append("                      ,A.BL_NO" ).append("\n"); 
		query.append("                      ,A.BKG_NO" ).append("\n"); 
		query.append("                      ,CASE WHEN A.BKG_CGO_TP_CD IN ('F','R') THEN 'F'" ).append("\n"); 
		query.append("                            WHEN A.BKG_CGO_TP_CD IN ('P') THEN 'M'" ).append("\n"); 
		query.append("                            ELSE '' " ).append("\n"); 
		query.append("                        END FULL_MTY_CD" ).append("\n"); 
		query.append("                      ,(SELECT W.KW_NM1 || ' AND ' ||  W.KW_NM2" ).append("\n"); 
		query.append("                          FROM BKG_USA_WHF_EXPT_CMDT W" ).append("\n"); 
		query.append("                         WHERE W.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                           AND W.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                           AND C.CSTMS_DESC LIKE '%' || W.KW_NM1 || '%'" ).append("\n"); 
		query.append("                           AND C.CSTMS_DESC LIKE '%' || W.KW_NM2 || '%'" ).append("\n"); 
		query.append("                           AND ROWNUM = 1" ).append("\n"); 
		query.append("                        ) AS KW_NM" ).append("\n"); 
		query.append("        #if (${io_bnd_cd} == 'I') " ).append("\n"); 
		query.append("                      ,CASE WHEN A.POD_CD <> A.BKG_POD_CD THEN 'T'" ).append("\n"); 
		query.append("                            WHEN A.BKG_POD_CD = A.DEL_CD THEN 'L'" ).append("\n"); 
		query.append("                            ELSE 'R'" ).append("\n"); 
		query.append("                        END AS USA_WHF_TRSP_TP_CD1" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("                      ,CASE WHEN A.BKG_POD_CD = A.DEL_CD THEN 'L'" ).append("\n"); 
		query.append("                            ELSE 'R'" ).append("\n"); 
		query.append("                        END AS USA_WHF_TRSP_TP_CD1" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT A.VSL_CD" ).append("\n"); 
		query.append("                              ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                              ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                              ,A.POD_CD" ).append("\n"); 
		query.append("                              ,A.POL_CD" ).append("\n"); 
		query.append("                              ,B.BL_NO" ).append("\n"); 
		query.append("                              ,B.BKG_NO" ).append("\n"); 
		query.append("                              ,B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                              ,B.POD_CD AS BKG_POD_CD" ).append("\n"); 
		query.append("                              ,B.DEL_CD" ).append("\n"); 
		query.append("                          FROM BKG_VVD A " ).append("\n"); 
		query.append("                              ,BKG_BOOKING B" ).append("\n"); 
		query.append("                         WHERE A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                           AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                           AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                           AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                           AND B.BL_NO  IS NOT NULL" ).append("\n"); 
		query.append("                           AND B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("                        #if (${io_bnd_cd} == 'I') " ).append("\n"); 
		query.append("                           AND A.POD_CD = @[port_cd]" ).append("\n"); 
		query.append("                        #else " ).append("\n"); 
		query.append("                           AND A.POL_CD = @[port_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                       ) A" ).append("\n"); 
		query.append("                      ,BKG_BL_DOC C" ).append("\n"); 
		query.append("                 WHERE A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("               ) BKG" ).append("\n"); 
		query.append("               ,BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("         WHERE  BKG.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("        ) TB" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("         SELECT USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append("               ,FULL_MTY_CD" ).append("\n"); 
		query.append("               ,USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("               ,USA_WHF_EXPT_FLG" ).append("\n"); 
		query.append("               ,WHF_UT_PRC" ).append("\n"); 
		query.append("           FROM BKG_USA_WHF_RT_DTL DTL" ).append("\n"); 
		query.append("               ,(SELECT MAX(EFF_DT) AS EFF_DT" ).append("\n"); 
		query.append("                   FROM BKG_USA_WHF_RT" ).append("\n"); 
		query.append("                  WHERE PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                    AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                ) MAX_RT" ).append("\n"); 
		query.append("          WHERE PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("            AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("            AND DTL.EFF_DT = MAX_RT.EFF_DT" ).append("\n"); 
		query.append("        ) RT" ).append("\n"); 
		query.append(" WHERE  TB.USA_WHF_RAT_UT_CD = RT.USA_WHF_RAT_UT_CD(+)" ).append("\n"); 
		query.append("   AND  TB.FULL_MTY_CD = RT.FULL_MTY_CD(+)" ).append("\n"); 
		query.append("   AND  TB.USA_WHF_TRSP_TP_CD = RT.USA_WHF_TRSP_TP_CD(+)" ).append("\n"); 
		query.append("   AND  TB.USA_WHF_EXPT_FLG = RT.USA_WHF_EXPT_FLG(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}