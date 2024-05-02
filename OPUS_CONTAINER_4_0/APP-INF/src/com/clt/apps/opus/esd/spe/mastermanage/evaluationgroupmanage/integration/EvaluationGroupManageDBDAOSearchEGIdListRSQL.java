/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupManageDBDAOSearchEGIdListVORSQL.java
*@FileTitle : Evaluation Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.07.23 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupManageDBDAOSearchEGIdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EvaluationGroupManageDBDAOSearchEGIdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.integration").append("\n"); 
		query.append("FileName : EvaluationGroupManageDBDAOSearchEGIdListVORSQL").append("\n"); 
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
		query.append("EG_ID||TO_CHAR(EG_ID_SEQ, '000') AS EG_ID," ).append("\n"); 
		query.append("EG_RHQ_CD||'-'||UPPER(EG_CTY_CD)||'-'||DECODE(SVC_CATE_CD, 'TR', 'TRUCK', 'RL', 'RAIL', 'CY', 'ODCY', 'TM', 'TERMINAL', 'WT', 'WATER', 'EQ', 'EQ M&R') AS EG_NAME," ).append("\n"); 
		query.append("EG_RHQ_CD," ).append("\n"); 
		query.append("UPPER(EG_CTY_CD) AS EG_CTY_CD," ).append("\n"); 
		query.append("DECODE(SVC_CATE_CD, 'TR', 'Truck', 'RL', 'Rail', 'CY', 'ODCY', 'TM', 'Terminal', 'WT', 'Water', 'EQ', 'EQ M&R') AS SVC_CATE_CD," ).append("\n"); 
		query.append("B.USR_NM||'/'||EG_PIC_USR_ID AS EG_PIC_USR_ID," ).append("\n"); 
		query.append("EG_ID_SEQ" ).append("\n"); 
		query.append("FROM SPE_EV_GRP A," ).append("\n"); 
		query.append("COM_USER B" ).append("\n"); 
		query.append("WHERE TRIM(A.EG_PIC_USR_ID) = TRIM(B.USR_ID(+))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eg_id} != '')" ).append("\n"); 
		query.append("AND A.EG_ID||TO_CHAR(EG_ID_SEQ,'000')=@[eg_id]" ).append("\n"); 
		query.append("#if (${eg_rhq_cd} != '')" ).append("\n"); 
		query.append("AND	A.EG_RHQ_CD = @[eg_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eg_cty_cd} != '')" ).append("\n"); 
		query.append("AND	UPPER(EG_CTY_CD) = @[eg_cty_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_cate_cd} != '')" ).append("\n"); 
		query.append("AND	A.SVC_CATE_CD = @[svc_cate_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${eg_rhq_cd} != '')" ).append("\n"); 
		query.append("AND	A.EG_RHQ_CD = @[eg_rhq_cd]" ).append("\n"); 
		query.append("AND	UPPER(EG_CTY_CD) = UPPER(@[eg_cty_cd])" ).append("\n"); 
		query.append("AND	A.SVC_CATE_CD = @[svc_cate_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY EG_ID||TO_CHAR(EG_ID_SEQ, '000') ASC" ).append("\n"); 

	}
}