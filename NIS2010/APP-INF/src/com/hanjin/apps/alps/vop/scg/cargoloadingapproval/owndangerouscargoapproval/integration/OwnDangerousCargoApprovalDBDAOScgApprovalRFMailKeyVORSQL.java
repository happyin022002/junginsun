/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOScgApprovalRFMailKeyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2010.03.03 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOScgApprovalRFMailKeyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RF type 의 승인 요청메일 중 같은 VVD의 BKG_NO를 조회한다.
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOScgApprovalRFMailKeyVORSQL(){
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOScgApprovalRFMailKeyVORSQL").append("\n"); 
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
		query.append("	B.BKG_NO" ).append("\n"); 
		query.append(",	B.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("FROM    SCG_APRO_RQST A" ).append("\n"); 
		query.append("    ,   SCG_VVD_APRO_RQST B" ).append("\n"); 
		query.append("    ,   (SELECT BKG_NO FROM BKG_RF_CGO WHERE SPCL_CGO_APRO_CD = 'R' GROUP BY BKG_NO) C" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.SPCL_CGO_APRO_RQST_SEQ  = B.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND A.SPCL_CGO_CATE_CD = 'RF'" ).append("\n"); 
		query.append("AND A.LST_RQST_DAT_FLG = 'Y'" ).append("\n"); 
		query.append("AND B.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 

	}
}