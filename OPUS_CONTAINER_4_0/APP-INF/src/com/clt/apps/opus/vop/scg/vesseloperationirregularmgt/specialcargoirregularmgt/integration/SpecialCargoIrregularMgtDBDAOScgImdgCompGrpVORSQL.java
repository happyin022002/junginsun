/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoIrregularMgtDBDAOScgImdgCompGrpVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.22 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoIrregularMgtDBDAOScgImdgCompGrpVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPCL CGO Irregular List의 Class Comp 조회
	  * </pre>
	  */
	public SpecialCargoIrregularMgtDBDAOScgImdgCompGrpVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoIrregularMgtDBDAOScgImdgCompGrpVORSQL").append("\n"); 
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
		query.append("SIG.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("FROM SCG_IMDG_COMP_GRP SIG" ).append("\n"); 
		query.append("WHERE EXISTS(" ).append("\n"); 
		query.append("SELECT 'A'" ).append("\n"); 
		query.append("FROM SCG_IRREGULAR SIR" ).append("\n"); 
		query.append(", SCG_IRR_CNTR SIC" ).append("\n"); 
		query.append("WHERE SIR.VSL_CD = SIC.VSL_CD" ).append("\n"); 
		query.append("AND SIR.SKD_VOY_NO = SIC.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SIR.SKD_DIR_CD = SIC.SKD_DIR_CD" ).append("\n"); 
		query.append("AND SIR.SPCL_CGO_IRR_SEQ = SIC.SPCL_CGO_IRR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${imdg_clss_cd} != '')" ).append("\n"); 
		query.append("AND SIC.IMDG_CLSS_CD = @[imdg_clss_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SIC.IMDG_COMP_GRP_CD = SIG.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY SIG.IMDG_COMP_GRP_CD" ).append("\n"); 

	}
}