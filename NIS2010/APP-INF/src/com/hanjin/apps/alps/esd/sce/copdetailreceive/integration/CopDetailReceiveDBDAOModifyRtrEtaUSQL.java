/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifyRtrEtaUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOModifyRtrEtaUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyRtrEta
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifyRtrEtaUSQL(){
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
		params.put("cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifyRtrEtaUSQL").append("\n"); 
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
		query.append("UPDATE SCE_RAIL_TZ_RPT" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("#if (${copItchgChk}=='1' || (${copItchgChk}=='2' && ${evnt_tp} == 'MAX'))" ).append("\n"); 
		query.append("RAIL_CO_DEST_PNT_ETA_DT = TO_DATE(@[rail_eta_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("#elseif (${copItchgChk}=='2' && ${evnt_tp} == 'MIN')" ).append("\n"); 
		query.append("RAIL_CO_ITCHG_PNT_ETA_DT = TO_DATE(@[rail_eta_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE  EQ_NO        = @[cntr_no]" ).append("\n"); 
		query.append("AND    BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND    CGO_TP_CD    = 'F'" ).append("\n"); 
		query.append("AND    TRSP_BND_CD  = (CASE WHEN TO_NUMBER(@[cop_dtl_seq]) > 6000 then 'I' WHEN TO_NUMBER(@[cop_dtl_seq]) < 4000 then 'O' end)" ).append("\n"); 
		query.append("AND    RPT_UPD_STS_CD  =  'N'" ).append("\n"); 

	}
}