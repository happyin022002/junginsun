/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOCopyCopDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.30
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.04.30 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOCopyCopDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * org_cop_no 의 cop detail 을 조회하여 신규 cop_no 로 생성한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOCopyCopDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOCopyCopDtlCSQL").append("\n"); 
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
		query.append("insert into sce_cop_dtl (" ).append("\n"); 
		query.append("COP_NO      ," ).append("\n"); 
		query.append("COP_DTL_SEQ     ," ).append("\n"); 
		query.append("ACT_CD          ," ).append("\n"); 
		query.append("PLN_DT          ," ).append("\n"); 
		query.append("ESTM_DT         ," ).append("\n"); 
		query.append("ACT_DT          ," ).append("\n"); 
		query.append("NOD_CD          ," ).append("\n"); 
		query.append("ACT_STS_CD      ," ).append("\n"); 
		query.append("ACT_RCV_TP_CD   ," ).append("\n"); 
		query.append("EDI_SND_TP_CD   ," ).append("\n"); 
		query.append("VSL_CD          ," ).append("\n"); 
		query.append("SKD_VOY_NO      ," ).append("\n"); 
		query.append("SKD_DIR_CD      ," ).append("\n"); 
		query.append("CLPT_IND_SEQ    ," ).append("\n"); 
		query.append("VPS_PORT_CD     ," ).append("\n"); 
		query.append("ESTM_GDT        ," ).append("\n"); 
		query.append("VNDR_SEQ        ," ).append("\n"); 
		query.append("EDI_MSG_TP_CD   ," ).append("\n"); 
		query.append("ACT_STS_MAPG_CD ," ).append("\n"); 
		query.append("STND_EDI_STS_CD ," ).append("\n"); 
		query.append("EDI_ACT_SND_DT  ," ).append("\n"); 
		query.append("ACT_DAT_RCV_DT  ," ).append("\n"); 
		query.append("COP_EXPT_FLG    ," ).append("\n"); 
		query.append("CRE_USR_ID      ," ).append("\n"); 
		query.append("CRE_DT          ," ).append("\n"); 
		query.append("UPD_USR_ID      ," ).append("\n"); 
		query.append("UPD_DT	)" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("@[cop_no]          ," ).append("\n"); 
		query.append("COP_DTL_SEQ     ," ).append("\n"); 
		query.append("ACT_CD          ," ).append("\n"); 
		query.append("PLN_DT          ," ).append("\n"); 
		query.append("ESTM_DT         ," ).append("\n"); 
		query.append("ACT_DT          ," ).append("\n"); 
		query.append("NOD_CD          ," ).append("\n"); 
		query.append("ACT_STS_CD      ," ).append("\n"); 
		query.append("ACT_RCV_TP_CD   ," ).append("\n"); 
		query.append("EDI_SND_TP_CD   ," ).append("\n"); 
		query.append("VSL_CD          ," ).append("\n"); 
		query.append("SKD_VOY_NO      ," ).append("\n"); 
		query.append("SKD_DIR_CD      ," ).append("\n"); 
		query.append("CLPT_IND_SEQ    ," ).append("\n"); 
		query.append("VPS_PORT_CD     ," ).append("\n"); 
		query.append("ESTM_GDT        ," ).append("\n"); 
		query.append("VNDR_SEQ        ," ).append("\n"); 
		query.append("EDI_MSG_TP_CD   ," ).append("\n"); 
		query.append("ACT_STS_MAPG_CD ," ).append("\n"); 
		query.append("STND_EDI_STS_CD ," ).append("\n"); 
		query.append("EDI_ACT_SND_DT  ," ).append("\n"); 
		query.append("ACT_DAT_RCV_DT  ," ).append("\n"); 
		query.append("COP_EXPT_FLG    ," ).append("\n"); 
		query.append("CRE_USR_ID      ," ).append("\n"); 
		query.append("CRE_DT          ," ).append("\n"); 
		query.append("UPD_USR_ID      ," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append("FROM SCE_COP_DTL" ).append("\n"); 
		query.append("WHERE COP_NO = @[org_cop_no])" ).append("\n"); 

	}
}