/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OpfUtilDBDAOVskVslPortLoadVolVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfUtilDBDAOVskVslPortLoadVolVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public OpfUtilDBDAOVskVslPortLoadVolVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration").append("\n"); 
		query.append("FileName : OpfUtilDBDAOVskVslPortLoadVolVORSQL").append("\n"); 
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
		query.append("WITH TMP AS (" ).append("\n"); 
		query.append("            SELECT	A.VPS_PORT_CD, A.SKD_VOY_NO, A.CLPT_SEQ, A.SKD_CNG_STS_CD, B.LOC_NM" ).append("\n"); 
		query.append("            FROM	VSK_VSL_PORT_SKD A, MDM_LOCATION B" ).append("\n"); 
		query.append("            WHERE	A.VSL_CD		=	@[vsl_cd]" ).append("\n"); 
		query.append("            AND     A.SKD_VOY_NO    =   @[skd_voy_no]" ).append("\n"); 
		query.append("            AND     A.SKD_DIR_CD    =   @[skd_dir_cd]" ).append("\n"); 
		query.append("            AND     A.VT_ADD_CALL_FLG IS NULL" ).append("\n"); 
		query.append("            AND     A.CLPT_SEQ      >   (	SELECT	CLPT_SEQ" ).append("\n"); 
		query.append("											FROM	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("											WHERE	VSL_CD		=	@[vsl_cd]" ).append("\n"); 
		query.append("											AND		SKD_VOY_NO 	=	@[skd_voy_no]" ).append("\n"); 
		query.append("											AND		SKD_DIR_CD	=	@[skd_dir_cd]" ).append("\n"); 
		query.append("											AND		YD_CD		=	@[yd_cd]" ).append("\n"); 
		query.append("                                            AND     CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("										)	" ).append("\n"); 
		query.append("            AND     A.VPS_PORT_CD = B.LOC_CD             " ).append("\n"); 
		query.append("            #if (${conti_cd} == '1')" ).append("\n"); 
		query.append("            AND		B.CONTI_CD			<>	(	SELECT	CONTI_CD" ).append("\n"); 
		query.append("                                                FROM	MDM_LOCATION" ).append("\n"); 
		query.append("                                                WHERE	LOC_CD		=	@[port_cd]" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("            #elseif (${conti_cd} == '2')" ).append("\n"); 
		query.append("            AND		B.CONTI_CD			= 	(	SELECT	CONTI_CD" ).append("\n"); 
		query.append("                                                FROM	MDM_LOCATION" ).append("\n"); 
		query.append("                                                WHERE	LOC_CD		=	@[port_cd]" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("            #end                 " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    VPS_PORT_CD," ).append("\n"); 
		query.append("    LOC_NM," ).append("\n"); 
		query.append("    CLPT_SEQ" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("    SELECT DECODE(A.SKD_CNG_STS_CD, 'S', NULL, A.VPS_PORT_CD) AS VPS_PORT_CD," ).append("\n"); 
		query.append("           DECODE(A.SKD_CNG_STS_CD, 'S', NULL, A.LOC_NM) AS LOC_NM," ).append("\n"); 
		query.append("           A.CLPT_SEQ," ).append("\n"); 
		query.append("           0 AS ORD" ).append("\n"); 
		query.append("      FROM TMP A" ).append("\n"); 
		query.append("     UNION" ).append("\n"); 
		query.append("    SELECT   Y.XTER_CD_CTNT, " ).append("\n"); 
		query.append("             A.LOC_NM, " ).append("\n"); 
		query.append("             A.CLPT_SEQ, " ).append("\n"); 
		query.append("             Y.XTER_CD_SUB_SEQ" ).append("\n"); 
		query.append("    FROM     OPF_XTER_CD_CONV_MST   X" ).append("\n"); 
		query.append("          ,  OPF_XTER_CD_CONV_DTL   Y" ).append("\n"); 
		query.append("          ,  TMP A" ).append("\n"); 
		query.append("    WHERE    X.XTER_CD_KND_CTNT     = Y.XTER_CD_KND_CTNT" ).append("\n"); 
		query.append("    AND      X.XTER_CD_KND_CTNT     = 'BLOCK_STOWAGE_OPTION_CGO'    " ).append("\n"); 
		query.append("    AND      X.DELT_FLG             = 'N'" ).append("\n"); 
		query.append("    AND      Y.DELT_FLG             = 'N'  " ).append("\n"); 
		query.append("    AND      Y.INTER_CD_CTNT        = A.VPS_PORT_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY CLPT_SEQ, ORD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}