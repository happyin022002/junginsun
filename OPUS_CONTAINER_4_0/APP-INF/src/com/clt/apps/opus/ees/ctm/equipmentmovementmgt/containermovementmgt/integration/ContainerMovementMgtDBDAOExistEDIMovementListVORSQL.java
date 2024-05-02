/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOExistEDIMovementListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOExistEDIMovementListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOExistEDIMovementListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOExistEDIMovementListVORSQL").append("\n"); 
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
		query.append("SELECT A.* FROM CTM_MOVEMENT A" ).append("\n"); 
		query.append(" WHERE A.CNTR_NO   = @[cntr_no]" ).append("\n"); 
		query.append("   AND A.ORG_YD_CD = @[evnt_yd_cd]" ).append("\n"); 
		query.append("   AND A.MVMT_CRE_TP_CD = 'A'" ).append("\n"); 
		query.append("   AND A.MVMT_STS_CD = @[edi_mvmt_sts_cd]" ).append("\n"); 
		query.append("   AND A.CNMV_EVNT_DT <= TO_DATE(@[evnt_dt],'YYYYMMDDHH24MISS') + 120/24" ).append("\n"); 
		query.append("   AND TO_DATE(@[evnt_dt],'YYYYMMDDHH24MISS') BETWEEN" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("         SELECT /*+INDEX_DESC(X XUK1CTM_MOVEMENT)*/" ).append("\n"); 
		query.append("                X.CNMV_EVNT_DT" ).append("\n"); 
		query.append("           FROM CTM_MOVEMENT X" ).append("\n"); 
		query.append("          WHERE X.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("            AND X.CNMV_YR||LPAD(X.CNMV_SEQ,5,'0') < A.CNMV_YR||LPAD(A.CNMV_SEQ,5,'0')" ).append("\n"); 
		query.append("            AND ROWNUM    = 1" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       AND" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("         SELECT /*+INDEX(X XUK1CTM_MOVEMENT)*/" ).append("\n"); 
		query.append("                X.CNMV_EVNT_DT" ).append("\n"); 
		query.append("           FROM CTM_MOVEMENT X" ).append("\n"); 
		query.append("          WHERE X.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("            AND X.CNMV_YR||LPAD(X.CNMV_SEQ,5,'0') > A.CNMV_YR||LPAD(A.CNMV_SEQ,5,'0')" ).append("\n"); 
		query.append("            AND ROWNUM    = 1" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}