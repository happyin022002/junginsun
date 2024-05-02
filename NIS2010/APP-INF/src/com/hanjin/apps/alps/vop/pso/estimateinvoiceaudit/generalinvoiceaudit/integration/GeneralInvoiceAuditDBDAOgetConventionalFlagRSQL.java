/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetConventionalFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetConventionalFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL 등록 국가 FLAG
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetConventionalFlagRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetConventionalFlagRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN CNT = 0 THEN '''N'''" ).append("\n"); 
		query.append("            ELSE '''Y'''" ).append("\n"); 
		query.append("            END AS FLG" ).append("\n"); 
		query.append(" FROM (  SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("           FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("          WHERE VSL_CD = SUBSTR( @[vvd], 1, 4)" ).append("\n"); 
		query.append("            AND VSL_RGST_CNT_CD IN (" ).append("\n"); 
		query.append("              'AL','AO','AG','AN','AU','AT','BS','BB'," ).append("\n"); 
		query.append("              'BE','BZ','BM','GW','BW','BN','BG','BF'," ).append("\n"); 
		query.append("              'BI','CM','CV','KY','TD','CZ','CN','KM'," ).append("\n"); 
		query.append("              'CD','CK','HR','CY','DK','DJ','DM','DO'," ).append("\n"); 
		query.append("              'EG','CQ','ER','EE','ET','FJ','FI','FK'," ).append("\n"); 
		query.append("              'FR','GA','GE','DE','GH','GI','GD','GN'," ).append("\n"); 
		query.append("              'HT','HK','HU','IS','IN','IR','IQ','IE'," ).append("\n"); 
		query.append("              'IL','IT','CI','JM','JP','JO','KE','KI'," ).append("\n"); 
		query.append("              'LV','LB','LS','LR','LY','LT','LU','MG'," ).append("\n"); 
		query.append("              'MY','MW','ML','MT','IM','MH','MR','MX'," ).append("\n"); 
		query.append("              'MC','MZ','NA','NR','NZ','NG','NO','PK'," ).append("\n"); 
		query.append("              'PW','PG','PL','PT','RO','RW','RU','KN'," ).append("\n"); 
		query.append("              'SH','LC','MF','VC','WS','SN','RS','SC'," ).append("\n"); 
		query.append("              'SL','SK','SI','SB','SO','ZA','ES','LK'," ).append("\n"); 
		query.append("              'SD','SR','SE','CH','TZ','TO','TT','TN'," ).append("\n"); 
		query.append("              'TR','TC','TV','UG','UA','GB','US','VU'," ).append("\n"); 
		query.append("              'VI','VG','ZM','ZW' ) )" ).append("\n"); 

	}
}