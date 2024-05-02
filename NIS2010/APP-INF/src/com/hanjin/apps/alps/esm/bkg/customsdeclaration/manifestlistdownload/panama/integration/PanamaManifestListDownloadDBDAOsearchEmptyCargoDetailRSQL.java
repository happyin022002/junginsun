/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PanamaManifestListDownloadDBDAOsearchEmptyCargoDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PanamaManifestListDownloadDBDAOsearchEmptyCargoDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEmptyCargoDetail
	  * </pre>
	  */
	public PanamaManifestListDownloadDBDAOsearchEmptyCargoDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("clpt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.integration").append("\n"); 
		query.append("FileName : PanamaManifestListDownloadDBDAOsearchEmptyCargoDetailRSQL").append("\n"); 
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
		query.append("X_MT_TOTAL," ).append("\n"); 
		query.append("X_MT_LOC," ).append("\n"); 
		query.append("X_MT_TS" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("X_MT_TOTAL," ).append("\n"); 
		query.append("X_MT_LOC," ).append("\n"); 
		query.append("X_MT_TS" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("X_CNTRTS_CD X_MT_TS," ).append("\n"); 
		query.append("DECODE(SIGN(F.VSL_TR_NO - 80), 0, 'A', 1, 'A', 'B') X_MT_LOC," ).append("\n"); 
		query.append("COUNT(DISTINCT X_CNTR_NO) X_MT_TOTAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("OPF_BAY_PLN_LDIS F," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("D.BKG_NO X_BKG_NO," ).append("\n"); 
		query.append("--D.BKG_NO_SPLIT X_BKG_NO_SPLIT," ).append("\n"); 
		query.append("D.POR_CD X_POR_CD," ).append("\n"); 
		query.append("D.POL_CD X_POL_CD," ).append("\n"); 
		query.append("D.POD_CD X_POD_CD," ).append("\n"); 
		query.append("D.DEL_CD X_DEL_CD," ).append("\n"); 
		query.append("D.BKG_STS_CD X_BKG_STS," ).append("\n"); 
		query.append("D.BKG_CGO_TP_CD X_BKG_CGO_TP," ).append("\n"); 
		query.append("G.BDR_DT X_BKG_BDR_DT," ).append("\n"); 
		query.append("E.CNTR_NO X_CNTR_NO," ).append("\n"); 
		query.append("E.CNTR_TPSZ_CD X_CNTRTS_CD," ).append("\n"); 
		query.append("B.VSL_CD X_VSL_CD," ).append("\n"); 
		query.append("B.SKD_VOY_NO X_SKD_VOY_NO," ).append("\n"); 
		query.append("B.SKD_DIR_CD X_SKD_DIR_CD," ).append("\n"); 
		query.append("B.VPS_PORT_CD X_VPS_POL_CD," ).append("\n"); 
		query.append("B.CLPT_IND_SEQ X_VPS_CALL_IND," ).append("\n"); 
		query.append("B.VPS_ETD_DT X_VPS_ETD_DT," ).append("\n"); 
		query.append("C.VPS_PORT_CD X_VPS_POD_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_VVD A," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD B," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD C," ).append("\n"); 
		query.append("BKG_BOOKING D," ).append("\n"); 
		query.append("BKG_CONTAINER E," ).append("\n"); 
		query.append("BKG_BL_DOC G" ).append("\n"); 
		query.append("WHERE A.VSL_CD        =  @[vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO    =  @[skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD    =  @[skd_dir_cd]" ).append("\n"); 
		query.append("AND B.VSL_CD(+)     =  A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO(+) =  A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD(+) =  A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.VPS_PORT_CD(+) =  A.POL_CD" ).append("\n"); 
		query.append("AND C.VSL_CD(+)     =  A.VSL_CD" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO(+) =  A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND C.SKD_DIR_CD(+) =  A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND C.VPS_PORT_CD(+) =  A.POD_CD" ).append("\n"); 
		query.append("AND NVL(C.CLPT_SEQ, 9999)  >  NVL(B.CLPT_SEQ, 0)" ).append("\n"); 
		query.append("AND NVL(B.CLPT_SEQ, 0)  <= @[clpt_seq]" ).append("\n"); 
		query.append("AND NVL(C.CLPT_SEQ, 9999)  >  @[clpt_seq]" ).append("\n"); 
		query.append("AND D.BKG_NO        =  A.BKG_NO" ).append("\n"); 
		query.append("AND D.BKG_STS_CD       IN ('W', 'F')" ).append("\n"); 
		query.append("AND D.BKG_CGO_TP_CD    IN ('P', 'R')" ).append("\n"); 
		query.append("AND E.BKG_NO        =  D.BKG_NO" ).append("\n"); 
		query.append("AND G.BKG_NO        =  D.BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE F.VSL_CD(+)        = X_VSL_CD" ).append("\n"); 
		query.append("AND F.SKD_VOY_NO(+)    = X_SKD_VOY_NO" ).append("\n"); 
		query.append("AND F.SKD_DIR_CD(+)    = X_SKD_DIR_CD" ).append("\n"); 
		query.append("AND F.VPS_PORT_CD(+)       = X_VPS_POL_CD" ).append("\n"); 
		query.append("AND F.CLPT_IND_SEQ(+)  = X_VPS_CALL_IND" ).append("\n"); 
		query.append("AND F.CNTR_REF_NO(+)   = X_CNTR_NO" ).append("\n"); 
		query.append("AND F.LODG_DCHG_IND_CD(+)    = 'L'" ).append("\n"); 
		query.append("GROUP BY X_CNTRTS_CD, DECODE(SIGN(F.VSL_TR_NO - 80), 0, 'A', 1, 'A', 'B')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${error_yn}== 'ERROR')" ).append("\n"); 
		query.append("WHERE X_MT_LOC = 'C'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}