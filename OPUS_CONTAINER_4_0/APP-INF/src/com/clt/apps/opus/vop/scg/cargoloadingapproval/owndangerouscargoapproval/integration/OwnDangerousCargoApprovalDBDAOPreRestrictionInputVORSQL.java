/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOPreRestrictionInputVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.17
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.05.17 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOPreRestrictionInputVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pre Checking Report 를 조회 합니다.   
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOPreRestrictionInputVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOPreRestrictionInputVORSQL").append("\n"); 
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
		query.append("SELECT '' F_CMD" ).append("\n"); 
		query.append(", A.BKG_NO" ).append("\n"); 
		query.append(", '' CRR_CD" ).append("\n"); 
		query.append(", '' POL_CD" ).append("\n"); 
		query.append(", '' POD_CD" ).append("\n"); 
		query.append(", '' SLAN_CD" ).append("\n"); 
		query.append(", '' VSL_CD" ).append("\n"); 
		query.append(", '' SKD_VOY_NO" ).append("\n"); 
		query.append(", '' SKD_DIR_CD" ).append("\n"); 
		query.append(", DENSE_RANK() OVER (PARTITION BY A.BKG_NO ORDER BY A.DG_CNTR_SEQ) AS SPCL_CNTR_SEQ" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY A.BKG_NO, A.DG_CNTR_SEQ ORDER BY A.DG_CNTR_SEQ, A.CNTR_CGO_SEQ) AS SPCL_CGO_SEQ" ).append("\n"); 
		query.append(", A.IMDG_CLSS_CD" ).append("\n"); 
		query.append(", A.IMDG_UN_NO" ).append("\n"); 
		query.append(", A.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(", '' OPT_CLSS" ).append("\n"); 
		query.append(", '' START_NUM" ).append("\n"); 
		query.append(", '' END_NUM" ).append("\n"); 
		query.append(", '' IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append(", '' IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append("FROM BKG_DG_CGO A" ).append("\n"); 
		query.append(", BKG_BOOKING B" ).append("\n"); 
		query.append(", SCG_IMDG_UN_NO C" ).append("\n"); 
		query.append("WHERE A.BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("AND A.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("AND A.IMDG_UN_NO     = C.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND A.IMDG_UN_NO_SEQ = C.IMDG_UN_NO_SEQ(+)" ).append("\n"); 

	}
}