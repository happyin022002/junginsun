/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialCargoIrregularMgtDBDAOVskCarrierVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2010.01.21 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoIrregularMgtDBDAOVskCarrierVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPCL CGO Irregular List의 Carrier Combo 조회
	  * </pre>
	  */
	public SpecialCargoIrregularMgtDBDAOVskCarrierVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoIrregularMgtDBDAOVskCarrierVORSQL").append("\n"); 
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
		query.append("SELECT VCR.CRR_CD" ).append("\n"); 
		query.append("     , VCR.CRR_NM" ).append("\n"); 
		query.append("  FROM SCG_IRREGULAR SIR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crr_cd} == 'vsl_opr_tp_cd') " ).append("\n"); 
		query.append("     , MDM_CARRIER VCR" ).append("\n"); 
		query.append("WHERE SIR.VSL_CRR_CD = VCR.CRR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${crr_cd} == 'cgo_opr_cd') " ).append("\n"); 
		query.append("     , MDM_CARRIER VCR" ).append("\n"); 
		query.append("WHERE SIR.CGO_OPR_CD = VCR.CRR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY" ).append("\n"); 
		query.append("       VCR.CRR_CD" ).append("\n"); 
		query.append("     , VCR.CRR_NM" ).append("\n"); 

	}
}