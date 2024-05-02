/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchCntrTpszCdByEqrRefRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOSearchCntrTpszCdByEqrRefRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCntrTpszCdByEqrRef
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchCntrTpszCdByEqrRefRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pln_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration ").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOSearchCntrTpszCdByEqrRefRSQL").append("\n"); 
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
		query.append("SELECT V.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    V.CNTR_QTY AS OP_CNTR_QTY" ).append("\n"); 
		query.append("FROM (SELECT VP.REF_ID," ).append("\n"); 
		query.append("        VQ.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        VQ.CNTR_QTY" ).append("\n"); 
		query.append("    FROM EQR_VSL_LODG_DCHG_EXE_PLN VP, EQR_VSL_EXE_PLN_QTY VQ" ).append("\n"); 
		query.append("    WHERE VP.REF_ID = VQ.REF_ID(+)" ).append("\n"); 
		query.append("    AND VQ.CNTR_QTY > 0" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT IP.REF_ID," ).append("\n"); 
		query.append("        IQ.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        IQ.CNTR_QTY" ).append("\n"); 
		query.append("    FROM EQR_INLND_TRSP_EXE_PLN IP, EQR_INLND_TRSP_EXE_PLN_QTY IQ" ).append("\n"); 
		query.append("    WHERE IP.REF_ID = IQ.REF_ID(+)" ).append("\n"); 
		query.append("    AND IQ.CNTR_QTY > 0" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT EP.REF_ID," ).append("\n"); 
		query.append("        EQ.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        EQ.CNTR_QTY" ).append("\n"); 
		query.append("    FROM EQR_ECC_INTER_EXE_PLN EP, EQR_ECC_INTER_EXE_PLN_QTY EQ" ).append("\n"); 
		query.append("    WHERE EP.REF_ID = EQ.REF_ID(+)" ).append("\n"); 
		query.append("    AND EQ.CNTR_QTY > 0" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT OP.REF_ID," ).append("\n"); 
		query.append("        OQ.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        OQ.CNTR_QTY" ).append("\n"); 
		query.append("    FROM EQR_ONF_HIR_EXE_PLN OP, EQR_ONF_HIR_EXE_PLN_QTY OQ" ).append("\n"); 
		query.append("    WHERE OP.REF_ID = OQ.REF_ID(+)" ).append("\n"); 
		query.append("    AND OQ.CNTR_QTY > 0) V" ).append("\n"); 
		query.append("WHERE V.REF_ID = @[mty_pln_no]" ).append("\n"); 

	}
}