/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfVslEtdMrnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfVslEtdMrnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchKrWhfVslEtdMrn
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfVslEtdMrnRSQL(){
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfVslEtdMrnRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  DECODE(@[io_bnd_cd], 'OO', TO_CHAR(A.VPS_ETD_DT,'YYYY-MM-DD'), TO_CHAR(A.VPS_ETA_DT,'YYYY-MM-DD') ) AS VPS_DT" ).append("\n"); 
		query.append(", B.PORT_CD" ).append("\n"); 
		query.append(", B.MRN_NO" ).append("\n"); 
		query.append(", B.MRN_CHK_NO" ).append("\n"); 
		query.append(", B.VSL_NM" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD A, BKG_CSTMS_KR_VVD_SMRY B" ).append("\n"); 
		query.append(" WHERE A.VSL_CD = SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("     AND A.SKD_VOY_NO   = SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("     AND A.SKD_DIR_CD   = SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("	#if (${vps_port_cd} != '') " ).append("\n"); 
		query.append("	 AND A.VPS_PORT_CD  = @[vps_port_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("     AND A.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("     AND B.VSL_CD     = A.VSL_CD" ).append("\n"); 
		query.append("     AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("     AND B.PORT_CD    = A.VPS_PORT_CD" ).append("\n"); 
		query.append("     AND B.IO_BND_CD  = SUBSTR( @[io_bnd_cd], 1, 1)" ).append("\n"); 
		query.append("	AND (B.OB_DECL_TP_CD, B.VVD_SEQ) IN (SELECT C.OB_DECL_TP_CD, MAX(C.VVD_SEQ)" ).append("\n"); 
		query.append("                                            FROM BKG_CSTMS_KR_VVD_SMRY C" ).append("\n"); 
		query.append("                                           WHERE C.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                                             AND C.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                                             AND C.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                                             AND C.PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("                                             AND C.IO_BND_CD = B.IO_BND_CD" ).append("\n"); 
		query.append("                                           GROUP BY OB_DECL_TP_CD)" ).append("\n"); 

	}
}