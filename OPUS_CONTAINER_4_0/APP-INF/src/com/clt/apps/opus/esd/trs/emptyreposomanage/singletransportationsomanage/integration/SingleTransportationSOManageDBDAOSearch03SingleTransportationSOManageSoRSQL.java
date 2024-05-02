/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearch03SingleTransportationSOManageSoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2011.03.22 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearch03SingleTransportationSOManageSoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_TRSP_SVC_ORD테이블 조회
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearch03SingleTransportationSOManageSoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sstoreqdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sfrmreqdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sfrmnode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stransmodcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stonode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sctrlofccd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearch03SingleTransportationSOManageSoRSQL").append("\n"); 
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
		query.append("TRSP_SO_CMB_SEQ FROM TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("WHERE A.TRSP_SO_CMB_SEQ IS NOT NULL" ).append("\n"); 
		query.append("AND A.TRSP_SO_TP_CD = 'M'" ).append("\n"); 
		query.append("AND A.TRSP_SO_STS_CD IN ('C', 'R')" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD = @[sctrlofccd]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${sfrmreqdate} != '' && ${sstoreqdate} != '')" ).append("\n"); 
		query.append("#if (${srad_date} == 'R')" ).append("\n"); 
		query.append("AND A.TRSP_MTY_RQST_DT BETWEEN TO_DATE(@[sfrmreqdate], 'YYYYMMDD') AND TO_DATE(@[sstoreqdate], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.LOCL_CRE_DT BETWEEN TO_DATE(@[sfrmreqdate], 'YYYYMMDD') AND TO_DATE(@[sstoreqdate], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${swh_kind} != 'ALL')" ).append("\n"); 
		query.append("AND (A.TRSP_MTY_COST_MOD_CD = @[skind])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${stransmodcd} != 'ALL')" ).append("\n"); 
		query.append("AND (A.TRSP_CRR_MOD_CD = @[stransmodcd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sfrmnode} != '')" ).append("\n"); 
		query.append("AND (A.FM_NOD_CD LIKE @[sfrmnode]||'%' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${stonode} != '')" ).append("\n"); 
		query.append("AND (A.TO_NOD_CD LIKE @[stonode]||'%' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($arrCntr.size() > 0)" ).append("\n"); 
		query.append("AND (A.EQ_NO IN (" ).append("\n"); 
		query.append("#foreach($cntrKey in ${arrCntr})" ).append("\n"); 
		query.append("#if($velocityCount < $arrCntr.size())" ).append("\n"); 
		query.append("'$cntrKey'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$cntrKey'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($arrReferencno.size() > 0)" ).append("\n"); 
		query.append("AND (A.REF_ID IN (" ).append("\n"); 
		query.append("#foreach($referKey in ${arrReferencno})" ).append("\n"); 
		query.append("#if($velocityCount < $arrReferencno.size())" ).append("\n"); 
		query.append("'$referKey'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$referKey'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}