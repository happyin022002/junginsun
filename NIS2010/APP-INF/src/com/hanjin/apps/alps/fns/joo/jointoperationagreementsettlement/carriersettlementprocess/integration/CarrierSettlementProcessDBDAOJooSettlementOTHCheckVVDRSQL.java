/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOJooSettlementOTHCheckVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.09.23 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOJooSettlementOTHCheckVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement OTH-OTH에서 VVD 입력시 AR_MST_REV_VVD 테이블을 조회해서 DATA가 없는 경우 VVD Clear
	  * DATA가 있는데 REV_YRMON이 null인 경우 (취소된 VVD) FNS_JOO_0053 화면을 POP-UP하여 SLIP단 같은 VVD를 조회하여 보여준다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOJooSettlementOTHCheckVVDRSQL(){
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
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration ").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOJooSettlementOTHCheckVVDRSQL").append("\n"); 
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
		query.append("SELECT REV_YRMON" ).append("\n"); 
		query.append("FROM   AR_MST_REV_VVD" ).append("\n"); 
		query.append("WHERE  VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    RLANE_DIR_CD = @[rev_dir_cd]" ).append("\n"); 

	}
}