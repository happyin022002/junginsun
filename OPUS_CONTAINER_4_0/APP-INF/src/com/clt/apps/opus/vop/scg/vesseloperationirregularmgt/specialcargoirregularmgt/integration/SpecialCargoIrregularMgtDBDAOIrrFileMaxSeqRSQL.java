/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoIrregularMgtDBDAOIrrFileMaxSeqRSQL.java
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

public class SpecialCargoIrregularMgtDBDAOIrrFileMaxSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCG_IRR_FILE_LIST 테이블의 Max Seqence 가져오기
	  * </pre>
	  */
	public SpecialCargoIrregularMgtDBDAOIrrFileMaxSeqRSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_irr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoIrregularMgtDBDAOIrrFileMaxSeqRSQL").append("\n"); 
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
		query.append("NVL(MAX(SPCL_CGO_IRR_FILE_SEQ),0)+1 SPCL_CGO_IRR_FILE_SEQ" ).append("\n"); 
		query.append("FROM SCG_IRR_FILE_LIST" ).append("\n"); 
		query.append("WHERE	VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND	SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND	SPCL_CGO_IRR_SEQ = @[spcl_cgo_irr_seq]" ).append("\n"); 

	}
}