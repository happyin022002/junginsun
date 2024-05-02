/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOgetCtmMvmtSeqRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier :
*@LastVersion : 1.0
* 2009.06.30
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung Min Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOgetCtmMvmtSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchMVMTSEQ(cnms_cd, cnmv_cgo_tp) - mvmt status seq를 구한다.
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOgetCtmMvmtSeqRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT FCNTR_FLG, CNMV_LVL_NO" ).append("\n");
		query.append("FROM CTM_MVMT_SEQ" ).append("\n");
		query.append("WHERE MVMT_STS_CD = @[sts_cd] AND BKG_CGO_TP_CD = @[cgo_cd]" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ").append("\n");
		query.append("FileName : ContainerMovementMgtDBDAOgetCtmMvmtSeqRSQL").append("\n");
		query.append("*/").append("\n");
	}
}