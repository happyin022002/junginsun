/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfBlChkListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.09.16 정재엽
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfBlChkListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfBlChkListRSQL(){
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
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfBlChkListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT T.CSTMS_DECL_TP_CD, T.BL_NO" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_BL T," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT T.BKG_NO, T.CSTMS_DECL_TP_CD, MAX(T.TRNS_SEQ) SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_BL T, MDM_LOCATION LOC," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT A.VSL_CD,   A.SKD_VOY_NO,  A.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_VVD_SMRY A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MRN_NO," ).append("\n"); 
		query.append("MRN_CHK_NO," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("PORT_CD," ).append("\n"); 
		query.append("OB_DECL_TP_CD," ).append("\n"); 
		query.append("MAX(VVD_SEQ) SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_VVD_SMRY" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND MRN_NO     = SUBSTR(@[mrn_no],1,10)" ).append("\n"); 
		query.append("AND MRN_CHK_NO = SUBSTR(@[mrn_no],11,1)" ).append("\n"); 
		query.append("AND IO_BND_CD  = SUBSTR(@[io_bnd_cd],1,1)" ).append("\n"); 
		query.append("AND PORT_CD    = @[port_cd]" ).append("\n"); 
		query.append("GROUP BY MRN_NO," ).append("\n"); 
		query.append("MRN_CHK_NO," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("PORT_CD," ).append("\n"); 
		query.append("OB_DECL_TP_CD" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.MRN_NO     	= SUBSTR(@[mrn_no],1,10)" ).append("\n"); 
		query.append("AND A.MRN_CHK_NO    = SUBSTR(@[mrn_no],11,1)" ).append("\n"); 
		query.append("AND A.IO_BND_CD     = SUBSTR(@[io_bnd_cd],1,1)" ).append("\n"); 
		query.append("AND A.PORT_CD       = @[port_cd]" ).append("\n"); 
		query.append("AND A.MRN_NO        = B.MRN_NO" ).append("\n"); 
		query.append("AND A.MRN_CHK_NO    = B.MRN_CHK_NO" ).append("\n"); 
		query.append("AND A.VSL_CD        = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO    = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD    = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.IO_BND_CD     = B.IO_BND_CD" ).append("\n"); 
		query.append("AND A.PORT_CD       = B.PORT_CD" ).append("\n"); 
		query.append("AND A.OB_DECL_TP_CD = B.OB_DECL_TP_CD" ).append("\n"); 
		query.append("AND A.VVD_SEQ       = B.SEQ" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE NVL(T.DELT_USR_ID,'N') = 'N'" ).append("\n"); 
		query.append("AND DECODE(@[io_bnd_cd],'II',T.TS_POD_CD,T.TS_POL_CD)  = LOC.LOC_CD" ).append("\n"); 
		query.append("AND T.CSTMS_DECL_TP_CD            IN (DECODE(@[io_bnd_cd],'OO','E','I'),DECODE(@[io_bnd_cd],'OO','R','T'))" ).append("\n"); 
		query.append("AND T.VSL_CD             = C.vsl_cd" ).append("\n"); 
		query.append("AND T.SKD_VOY_NO         = C.skd_voy_no" ).append("\n"); 
		query.append("AND T.SKD_DIR_CD         = C.skd_dir_cd" ).append("\n"); 
		query.append("GROUP BY T.BKG_NO, T.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append(") U" ).append("\n"); 
		query.append("WHERE DECODE(@[io_bnd_cd],'II', T.TS_POD_CD, T.TS_POL_CD) = @[port_cd]" ).append("\n"); 
		query.append("AND NVL(T.DELT_USR_ID, 'N') = 'N'" ).append("\n"); 
		query.append("AND T.CSTMS_DECL_TP_CD IN (DECODE(@[io_bnd_cd],'IN','I','II','I','IT','T','OO','E','OT','R'),DECODE(@[io_bnd_cd],'IN','T','II','I','IT','T','OO','E','OT','R'))" ).append("\n"); 
		query.append("AND T.BKG_NO             = U.BKG_NO" ).append("\n"); 
		query.append("AND T.CSTMS_DECL_TP_CD   = U.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("AND T.TRNS_SEQ           = U.SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT WHF_BND_CD," ).append("\n"); 
		query.append("BL_NO" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_BL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VSL_CD      = SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("AND SKD_VOY_NO  = SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("AND SKD_DIR_CD  = SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("AND WHF_BND_CD IN (DECODE(@[io_bnd_cd],'IN','I','II','I','IT','T','OO','E','OT','R'),DECODE(@[io_bnd_cd],'IN','T','II','I','IT','T','OO','E','OT','R'))" ).append("\n"); 
		query.append("AND DECODE(@[io_bnd_cd], 'II', WHF_POD_CD, WHF_POL_CD) = @[port_cd]" ).append("\n"); 
		query.append("AND WHF_BL_STS_CD   != 'D'" ).append("\n"); 

	}
}