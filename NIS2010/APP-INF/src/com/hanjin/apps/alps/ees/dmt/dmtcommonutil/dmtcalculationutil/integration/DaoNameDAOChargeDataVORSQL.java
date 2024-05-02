/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DaoNameDAOChargeDataVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.24
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.01.24 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM TAE KYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOChargeDataVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeDataVO
	  * </pre>
	  */
	public DaoNameDAOChargeDataVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ").append("\n"); 
		query.append("FileName : DaoNameDAOChargeDataVORSQL").append("\n"); 
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
		query.append("	'' Z_POST_RLY           															" ).append("\n"); 
		query.append("	,'' Z_POL_LOC            															" ).append("\n"); 
		query.append("	,'' Z_RFA_APPR_NO        															" ).append("\n"); 
		query.append("	,'' Z_SC_VER_SEQ         															" ).append("\n"); 
		query.append("	,'' Z_RFA_DTL_SEQ        															" ).append("\n"); 
		query.append("	,'' Z_SC_CUR_CD          															" ).append("\n"); 
		query.append("	,'' Z_RFA_CUR_CD         															" ).append("\n"); 
		query.append("	,'' Z_DC_APPL_RATE       															" ).append("\n"); 
		query.append("	,'' Z_RFA_DAR_NO         															" ).append("\n"); 
		query.append("	,'' Z_DBC_IO_BND         															" ).append("\n"); 
		query.append("	,'' Z_SC_NO              															" ).append("\n"); 
		query.append("	,'' BZC_TRF_APLY_DT      															" ).append("\n"); 
		query.append("	,'' Z_RFA_VER_SEQ        															" ).append("\n"); 
		query.append("	,'' Z_VSL_CD             															" ).append("\n"); 
		query.append("	,'' Z_DEL_LOC            															" ).append("\n"); 
		query.append("	,'' Z_DTG_GRP_ID         															" ).append("\n"); 
		query.append("	,'' Z_DTN_SEQ            															" ).append("\n"); 
		query.append("	,'' Z_PRE_RLY            															" ).append("\n"); 
		query.append("	,'' Z_CUR_CD             															" ).append("\n"); 
		query.append("	,'' Z_POR_LOC            															" ).append("\n"); 
		query.append("	,'' Z_DCC_TRS_IND        															" ).append("\n"); 
		query.append("	,'' Z_OFC_CD             															" ).append("\n"); 
		query.append("	,'' Z_SC_GRP_SEQ         															" ).append("\n"); 
		query.append("	,'' Z_SKD_DIR_CD         															" ).append("\n"); 
		query.append("	,'' Z_BKG_NO             															" ).append("\n"); 
		query.append("	,'' Z_RFA_MAPG_SEQ       															" ).append("\n"); 
		query.append("	,'' Z_CNTRTS_CD          															" ).append("\n"); 
		query.append("	,'' Z_SKD_VOYAGE_NO      															" ).append("\n"); 
		query.append("	,'' Z_POD_LOC            															" ).append("\n"); 
		query.append("	,'' Z_OFC_RHQ            															" ).append("\n"); 
		query.append("	,'' Z_SC_RFA_EXPT_APLY_DT															" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}